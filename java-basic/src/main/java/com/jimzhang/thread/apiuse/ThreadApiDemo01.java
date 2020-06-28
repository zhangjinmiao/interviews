package com.jimzhang.thread.apiuse;

/**
 * 〈一句话功能简述〉<br> 〈线程 API 使用〉
 *
 * 一般创建线程推荐使用：实现接口的方式，因为还可以继承其他类，扩展性好
 * @author zhangjinmiao
 * @create 2019/7/27 12:02
 */
public class ThreadApiDemo01 implements Runnable{

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        // TODO: handle exception
      }

//      	System.out.println("线程id:" + getId() + ":子线程 ,i:" + i + "name:" + getName());
//      System.out.println("线程id:" + Thread.currentThread().getId() + ":子线程 ,i:" + i + "name:" +Thread.currentThread().getName());
      if(i==5){
        Thread.currentThread().stop();// 不安全。不建议大家使用。
      }

    }
  }
}

class Test04 {
  public static void main(String[] args) {
    // 获取主线程的id
    // 任何一个程序肯定有一个主线程

//    	Thread.currentThread()获取到当前线程的
    ThreadApiDemo01 t1 = new ThreadApiDemo01();
    Thread thread = new Thread(t1,"子线程");
    thread.start();

  }
}