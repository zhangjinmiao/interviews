package com.jimzhang.thread.create;

/**
 * 〈一句话功能简述〉<br> 〈创建线程：匿名内部类〉
 *
 * @author zhangjinmiao
 * @create 2019/7/27 11:56
 */
public class ThreadDemo03 {

  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 30; i++) {
          System.out.println("子线程:"+i);
        }
      }
    });

    thread.start();
    for (int i = 0; i < 30; i++) {
      System.out.println("主线程:"+i);
    }
  }
}
