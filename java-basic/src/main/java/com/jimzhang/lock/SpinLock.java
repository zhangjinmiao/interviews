package com.jimzhang.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *
 * lock（)方法利用的CAS，当第一个线程A获取锁的时候，能够成功获取到，不会进入while循环，如果此时线程A没有释放锁，另一个线程B又来获取锁，
 * 此时由于不满足CAS，所以就会进入while循环，不断判断是否满足CAS，直到A线程调用unlock方法释放了该锁。
 */
public class SpinLock {
    private AtomicReference cas = new AtomicReference();

    public void lock(){
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }

}
