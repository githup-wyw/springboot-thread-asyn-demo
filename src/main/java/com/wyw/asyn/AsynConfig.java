package com.wyw.asyn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: shouxin
 * @description: AsynConfig
 * @author: Mr.WYW
 * @create: 2019-11-08 12:异步配置
 */
@Configuration
@EnableAsync
public class AsynConfig {

    // 核心线程数
    @Value("${async.corePoolSize}")
    private int corePoolSize;

    // 最大线程数
    @Value("${async.maxPoolSize}")
    private int maxPoolSize;

    // 队列大小
    @Value("${async.queueCapacity}")
    private int queueCapacity;

    // 线程最大空闲时间
    @Value("${async.keepAliveSeconds}")
    private int keepAliveSeconds;

    // 指定用于新创建的线程名称的前缀
    @Value("${async.threadNamePrefix}")
    private String threadNamePrefix;


    @Bean
    public TaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize); //核心线程数
        executor.setMaxPoolSize(maxPoolSize);  //最大线程数
        executor.setQueueCapacity(queueCapacity); //队列大小
        executor.setKeepAliveSeconds(keepAliveSeconds); //线程最大空闲时间
        executor.setThreadNamePrefix(threadNamePrefix); //指定用于新创建的线程名称的前缀。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}
