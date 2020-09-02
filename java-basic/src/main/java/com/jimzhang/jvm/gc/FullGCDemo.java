package com.jimzhang.jvm.gc;

/**
 * 参考：
 * 启动参数：
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:SurvivorRatio=8  -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *
 * -XX:PretenureSizeThreshold=3145728：超过3MB，就直接进入老年代
 */
public class FullGCDemo {

    public static void main(String[] args) {
        byte[] array1 = new byte[4 * 1024 *1024];
        array1 = null;

        byte[] array2 = new byte[2 * 1024 *1024];
        byte[] array3 = new byte[2 * 1024 *1024];
        byte[] array4 = new byte[2 * 1024 *1024];
        byte[] array5 = new byte[128 *1024];

        byte[] array6 = new byte[2 * 1024 *1024];
    }
    
}
