package com.jimzhang.thread.apiuse;

/**
 * 〈一句话功能简述〉<br> 〈〉
 * t1 先执行，然后 t2才开始执行；t2执行完，t3才可执行
 * @author zhangjinmiao
 * @create 2019/7/27 13:18
 */
public class ThreadJoin {

  public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {

      @Override
      public void run() {
        for (int i = 0; i < 20; i++) {
          System.out.println("T1,i:" + i);
        }
      }
    });
    t1.start();
    Thread t2 = new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          t1.join(); // 等待 t1 执行完毕再执行
        } catch (Exception e) {
          // TODO: handle exception
        }
        for (int i = 0; i < 20; i++) {
          try {
            Thread.sleep(30);
          } catch (Exception e) {
            // TODO: handle exception
          }
          System.out.println("T2,i:" + i);
        }
      }
    });

    t2.start();
    Thread t3 = new Thread(new Runnable() {

      @Override
      public void run() {
        try {
          t2.join();// 等待 t2 执行完毕再执行
        } catch (Exception e) {
          // TODO: handle exception
        }
        for (int i = 0; i < 20; i++) {
          try {
            Thread.sleep(30);
          } catch (Exception e) {
            // TODO: handle exception
          }
          System.out.println("T3,i:" + i);
        }
      }
    });

    t3.start();
  }
}
