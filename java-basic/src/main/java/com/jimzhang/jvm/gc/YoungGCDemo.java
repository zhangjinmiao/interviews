package com.jimzhang.jvm.gc;

/**
 * 参考：https://apppukyptrl1086.pc.xiaoe-tech.com/detail/i_5d11e5a85d6b2_DwhvAoB3/1?from=p_5d0ef9900e896_MyDfcJi8&type=6
 * 启动参数：
 * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *
 * -XX:InitialHeapSize”和“-XX:MaxHeapSize”就是初始堆大小和最大堆大小，
 * “-XX:NewSize”和“-XX:MaxNewSize”是初始新生代大小和最大新生代大小，
 * “-XX:PretenureSizeThreshold=10485760”指定了大对象阈值是10MB
 *
 * 堆内存分配10MB内存空间，其中新生代是5MB内存空间，其中Eden区占4MB，每个Survivor区占0.5MB，大对象必须超过10MB才会直接进入老年代，年轻代使用ParNew垃圾回收器，老年代使用CMS垃圾回收器
 *
 */
public class YoungGCDemo {

    public static void main(String[] args) {
        byte[] array1 = new byte[1024 *1024]; // Eden区内放入一个1MB的对象，同时在main线程的虚拟机栈中会压入一个main()方法的栈帧，在main()方法的栈帧内部，会有一个“array1”变量，这个变量是指向堆内存Eden区的那个1MB的数组
        array1 = new byte[1024 *1024]; // 在堆内存的Eden区中创建第二个数组，并且让局部变量指向第二个数组，然后第一个数组就没人引用了，此时第一个数组就成了没人引用的“垃圾对象”了
        array1 = new byte[1024 *1024]; // 在堆内存的Eden区内创建了第三个数组，同时让array1变量指向了第三个数组，此时前面两个数组都没有人引用了，就都成了垃圾对象
        array1 = null; // 让array1这个变量什么都不指向了，此时会导致之前创建的3个数组全部变成垃圾对象

        byte[] array2 = new byte[2 * 1024 *1024]; // 分配一个2MB大小的数组，尝试放入Eden区中，因为Eden区总共就4MB大小，而且里面已经放入了3个1MB的数组了，所以剩余空间只有1MB了，此时你放一个2MB的数组是放不下的，这个时候就会触发年轻代的Young GC
    }
}
