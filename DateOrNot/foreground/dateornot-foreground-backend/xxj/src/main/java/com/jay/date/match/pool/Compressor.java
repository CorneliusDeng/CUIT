package com.jay.date.match.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 匹配池整理器
 * 压缩器定时执行，防止匹配池数据不均匀
 * 将所有用户靠前分布，提高匹配成功率
 * @author Jay
 */
@Component
public class Compressor {
    private final MatchPoolContainer poolContainer;
    private final Logger logger;
    private final ScheduledThreadPoolExecutor executor;

    private Boolean enabled = true;
    /**
     * 整理器执行周期
     */
    private static final int COMPRESSION_PERIOD = 20000;
    /**
     * 整理器开始延迟
     */
    private static final int INITIAL_DELAY = 3000;

    private static final double START_COMPRESS_RATIO = 0.1;

    @Autowired
    public Compressor(MatchPoolContainer poolContainer) {
        this.poolContainer = poolContainer;
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.executor = new ScheduledThreadPoolExecutor(1, r -> new Thread(r, "c-thread-0"));

    }

    @PostConstruct
    private void init(){
        // 提交定时任务
        executor.scheduleAtFixedRate(this::compression, INITIAL_DELAY, COMPRESSION_PERIOD, TimeUnit.MILLISECONDS);
        logger.info("已初始化整理器，默认启动延迟：{}ms，执行间隔：{}ms，当前状态：{}", INITIAL_DELAY, COMPRESSION_PERIOD, enabled?"开启":"关闭");
    }

    /**
     * 定时整理匹配池
     * 尽量将用户整理到靠前的匹配池中
     */
    private void compression() {
        // 如果整理器被关闭，则不会继续整理器方法
        if(!enabled){
            return;
        }
        /*
            整理前必须锁poolContainer
            避免与监视器出现线程安全问题
         */
        synchronized (poolContainer){
            logger.info("匹配池 整理开始");
            int transferredCount = 0;
            List<MatchPool> pools = poolContainer.getPools();
        /*
            整理开始，先将所有匹配线程打断
            匹配线程被打断后会调用park()暂停
         */
            for(MatchPool pool : pools){
                pool.lock.lock();
            }
            long startTime = System.currentTimeMillis();
        /*
            整理匹配池
            保证每个匹配池的用户量在一个均匀的水平
         */
            for(int i = pools.size() - 1; i > 0; i--){
                MatchPool pool = pools.get(i);
                Queue<MatchPoolUserInfo> queue = pool.getQueue();
                // queue中的元素少于压缩比例
                if(queue.size() < MatchPool.CAPACITY * START_COMPRESS_RATIO){
                    // 向前整理
                    for(int j = 0; j < i; j++){
                        Queue<MatchPoolUserInfo> preQueue = pools.get(j).getQueue();
                        while(!queue.isEmpty() && preQueue.size() < MatchPool.CAPACITY){
                            transferredCount++;
                            MatchPoolUserInfo userInfo = queue.poll();
                            // 超时，直接清除
                            if(System.currentTimeMillis() - userInfo.getTimestamp() < 60000){
                                preQueue.add(userInfo);
                            }
                        }
                    }
                }
            }
            logger.info("匹配池 整理完成，耗时：{}ms，共转移用户：{}", System.currentTimeMillis() - startTime, transferredCount);
            logger.info("各匹配池用户数量：");
            pools.forEach((pool)-> logger.info("poolId={}, 人数：{}", pool.poolId, pool.getQueue().size()));
            // 重启匹配线程
            for(MatchPool pool : pools){
                pool.lock.unlock();
            }
        }
    }

    @Deprecated
    public Boolean getEnabled() {
        return enabled;
    }
    @Deprecated
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
