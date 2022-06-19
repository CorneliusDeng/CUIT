package com.jay.date.match.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 匹配池容器
 * 初始化和存储所有的匹配池
 * @author Jay
 */
@Component
public class MatchPoolContainer {
    /**
     * 匹配池个数
     */
    private int poolCount = 3;
    /**
     * 匹配池数量为主机cpu核心数
     * 即用户量最大时，每个匹配池能够分配到一个cpu核心来并行匹配
     *
     * 根据公式：线程数 =  CPU的核心数 * （1 - 阻塞系数）
     * 该场景为计算密集型，不存在长时间阻塞，所以阻塞系数为 0
     */
    private static final int MAX_POOL_COUNT = Runtime.getRuntime().availableProcessors() + 2;
    private final List<MatchPool> pools;
    private final Logger logger;

    public MatchPoolContainer(){
        logger = LoggerFactory.getLogger(this.getClass());
        // 避免匹配池数量超过主机cpu核心数
        this.poolCount = Math.min(this.poolCount, MAX_POOL_COUNT);
        // 创建匹配池集合
        pools = new ArrayList<>(MAX_POOL_COUNT);

        logger.info("已初始化匹配池容器，初始匹配池数量：{}，最大匹配池数量：{}", poolCount, MAX_POOL_COUNT);
    }

    @PostConstruct
    public void init(){
        for(int i = 0; i < poolCount; i++){
            pools.add(new MatchPool(i));
        }
        logger.info("创建匹配池已完成");
    }

    public List<MatchPool> getPools() {
        return pools;
    }

    /**
     * 获取当前运行匹配池数量
     * @return 运行匹配池数量
     */
    @Deprecated
    public int getPoolCount() {
        return poolCount;
    }

    /**
     * 设置运行匹配池数量
     * 用于动态扩容的场景
     * @param poolCount 池数量
     */
    @Deprecated
    public void setPoolCount(int poolCount) {
        this.poolCount = poolCount;
    }
}
