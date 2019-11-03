package com.jack.learn.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/2/23.
 *
 * @author liweijian.
 */
@Configuration
public class AsyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10));
//        executor.setCorePoolSize(10);
//        executor.setMaxPoolSize(30);
//        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
