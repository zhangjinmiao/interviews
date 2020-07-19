package com.jimzhang.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义拒绝策略
 */
public class RejectedDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),
                new RejectedExecutionHandler() {  // 添加自定义拒绝策略
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        // 业务处理方法
                        System.out.println("执行自定义拒绝策略");
                    }
                });
        for (int i = 0; i < 6; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
