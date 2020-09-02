package com.jimzhang.juc;

import java.util.concurrent.CountDownLatch;

public class Race {

    public static void race(int racerCnt) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(racerCnt);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(racerCnt);

        for (int i = 0; i < racerCnt; i++) {
            final int racerNo = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ready: " + racerNo);
                    ready.countDown();
                    try {
                        start.await();
                        System.out.println("start: " + racerNo);
                    } catch (InterruptedException e) {
                        System.out.println("I am hurt, and have to interrupt the race...");
                        Thread.currentThread().interrupt();
                    } finally {
                        System.out.println("end: " + racerNo);
                        end.countDown();
                    }
                }
            }).start();
        }

        ready.await();
        System.out.println("********************** all ready!!! **********************");
        System.out.println("********************** will start soon **********************");
        start.countDown();
        end.await();
        System.out.println("********************** all end!!! **********************");
    }

    public static void main(String[] args) throws InterruptedException {
        race(5);
    }
}
