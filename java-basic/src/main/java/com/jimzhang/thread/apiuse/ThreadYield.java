package com.jimzhang.thread.apiuse;

/**
 * 放弃当前线程获取CPU的执行权，将让其它的线程去获取。但这个是不固定的。
 */
public class ThreadYield {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程：" + Thread.currentThread().getName() + " I：" + i);
                    if (i == 5) {
                        Thread.yield();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable, "T1");
        Thread t2 = new Thread(runnable, "T2");
        t1.start();
        t2.start();
    }
}
