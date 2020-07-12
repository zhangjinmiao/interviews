package com.jimzhang.lock;

/**
 * 可重入锁
 *
 */
public class ReentrantDemo {
    /**
     * 可重入锁 A 方法
     */
    private synchronized static void reentrantA() {
        System.out.println(Thread.currentThread().getName() + "：执行 reentrantA");
        reentrantB();
    }
    /**
     * 可重入锁 B 方法
     */
    private synchronized static void reentrantB() {
        System.out.println(Thread.currentThread().getName() + "：执行 reentrantB");
    }

    /**
     * 从结果可以看出 reentrantA 方法和 reentrantB 方法的执行线程都是“main” ，我们调用了 reentrantA 方法，它的方法中嵌套了 reentrantB，
     * 如果 synchronized 是不可重入的话，那么线程会被一直堵塞。
     * @param args
     */
    public static void main(String[] args) {
        reentrantA(); // 可重入锁
    }
}
