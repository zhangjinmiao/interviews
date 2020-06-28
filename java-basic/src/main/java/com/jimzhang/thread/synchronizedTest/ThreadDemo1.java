package com.jimzhang.thread.synchronizedTest;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * @author zhangjinmiao
 * @create 2019/8/28 19:24
 */
public class ThreadDemo1 {

  public static void main(String[] args) throws InterruptedException {
    Thread01 t = new Thread01();

    Thread t1 = new Thread(t,"窗口1");
    Thread t2 = new Thread(t,"窗口2");

    t1.start();

    Thread.sleep(50);
    Thread01.flag=false;
    t2.start();
  }
}
