package com.macro.mall.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OSS对象存储相关配置 Created by macro on 2018/5/17.
 */
@Configuration
public class OssConfig {

    @Value("${aliyun.oss.endpoint}")
    private String aliyunOssEndpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String aliyunOssAccesskeyid;
    @Value("${aliyun.oss.accessKeySecret}")
    private String aliyunOssAccesskeysecret;

    @Bean
    public OSSClient ossClient() {
        return new OSSClient(aliyunOssEndpoint, aliyunOssAccesskeyid, aliyunOssAccesskeysecret);
    }
}
