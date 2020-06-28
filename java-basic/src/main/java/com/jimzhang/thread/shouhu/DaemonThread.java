package com.jimzhang.thread.shouhu;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * 用户线程 是主线程创建的线程，非守护线程
 * 守护线程 和主线程一起销毁。
 *
 * @author zhangjinmiao
 * @create 2019/7/27 13:20
 */
public class DaemonThread {

  public static void main(String[] args) {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 30; i++) {
          try {
            Thread.sleep(300);
          } catch (Exception e) {
            // TODO: handle exception
          }
          System.out.println("子线程,i:" + i);
        }
      }
    });
    t1.setDaemon(true);//该线程为守护线程 和主线程一起销毁
    t1.start();
    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(300);
      } catch (Exception e) {
        // TODO: handle exception
      }
      System.out.println("主线程,i:" + i);
    }
    System.out.println("主线程执行完毕.....");
  }


}
