package com.springboottemplate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/4/7 16:42
 */

/**
 *
 简单理解：
 1、ThreadPoolTaskExecutor使用ThreadPoolExecutor并增强，扩展了更多特性
 2、ThreadPoolTaskExecutor只关注自己增强的部分，任务执行还是ThreadPoolExecutor处理。
 3、前者spring自己用着爽，后者离开spring我们用ThreadPoolExecutor爽。
 注意：ThreadPoolTaskExecutor 不会自动创建ThreadPoolExecutor需要手动调initialize才会创建
 如果@Bean 就不需手动，会自动InitializingBean的afterPropertiesSet来调initialize
 */

/**
 * ThreadPoolTaskExecutor 线程池的特点
 * 1.当一个任务被提交到线程池时，首先查看线程池的核心线程是否都在执行任务，否就选择一条线程执行任务，就是执行第二步。
 *
 * 2.查看核心线程池是否已满，不满就创建一条线程执行任务，否则执行第三步。
 *
 * 3.查看任务队列是否已满，不满就将任务存储在任务队列中，否则执行第四步。
 *
 * 4.查看线程池是否已满，不满就创建一条线程执行任务，否则就按照策略处理无法执行的任务。
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize;
    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;
    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity;
    @Value("${async.executor.thread.name.prefix}")
    private String namePrefix;

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(namePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}