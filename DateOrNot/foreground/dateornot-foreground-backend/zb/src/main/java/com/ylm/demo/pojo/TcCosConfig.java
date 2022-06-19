package com.ylm.demo.pojo;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 腾讯云COS配置类
 * 包含腾讯云配置信息和cos客户端生成方法
 */
@Configuration
@Data
public class TcCosConfig {

    @Value("${tencent.cos.SecretId}")
    private String secretId;

    @Value("${tencent.cos.SecretKey}")
    private String secretKey;

    @Value("${tencent.cos.region}")
    private String region;

    @Value("${tencent.cos.bucketName}")
    private String bucketName;

    @Value("${tencent.cos.url}")
    private String path;


    @Bean
    public COSClient cosClient(){
        // 1 初始化用户身份信息（secretId, secretKey）。
        COSCredentials cred = new BasicCOSCredentials(this.secretId, this.secretKey);
        // 2 设置 bucket 的区域, 参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法
        Region region = new Region(this.region);
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 返回生成的 cos 客户端。
        return new COSClient(cred, clientConfig);
    }
}