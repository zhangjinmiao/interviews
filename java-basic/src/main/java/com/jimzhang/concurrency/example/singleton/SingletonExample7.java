package com.jimzhang.concurrency.example.singleton;

import com.jimzhang.concurrency.annoations.Recommend;
import com.jimzhang.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有构造函数
    public SingletonExample7() {
    }

    // 单例对象
    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public enum  Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
