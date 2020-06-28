package com.jimzhang.thread.create;

/**
 * 〈一句话功能简述〉<br> 〈创建线程：实现 Runnable 接口〉
 *
 * @author zhangjinmiao
 * @create 2019/7/27 11:52
 */
public class ThreadDemo02 implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 30; i++) {
      System.out.println("子线程 run,i:" + i);
    }
  }
}

class Test02{
  public static void main(String[] args) {
    ThreadDemo02 t1 = new ThreadDemo02();
    Thread thread = new Thread(t1);
    thread.start();
    for (int i = 0; i < 30; i++) {
      System.out.println("主线程 i:" + i);
    }
  }
}