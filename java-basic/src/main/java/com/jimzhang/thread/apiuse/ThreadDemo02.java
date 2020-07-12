package com.jimzhang.thread.apiuse;

/**
 * 〈一句话功能简述〉<br> 〈join〉
 *
 * @author zhangjinmiao
 * @create 2019/7/27 12:11
 */
public class ThreadDemo02 {

  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        for (int i = 0; i < 60; i++) {
          System.out.println("子线程,i:"+i);
        }
      }
    });
    thread.start();
    // 主线程让子线程先执行完毕的话，怎么做？
    try {
      thread.join();
//      thread.join(2000); // 可以先让子线程执行2秒后主线程再执行
    } catch (Exception e) {
      // TODO: handle exception
    }
    for (int i = 0; i < 30; i++) {
      System.out.println("主线程,i:"+i);
    }
  }
}
