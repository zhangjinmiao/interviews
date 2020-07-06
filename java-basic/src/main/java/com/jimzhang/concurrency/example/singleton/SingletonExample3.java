package com.jimzhang.concurrency.example.singleton;

import com.jimzhang.concurrency.annoations.NotRecommend;
import com.jimzhang.concurrency.annoations.NotThreadSafe;
import com.jimzhang.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数
    public SingletonExample3() {
    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态的工厂方法
    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
