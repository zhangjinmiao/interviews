package com.jimzhang.thread.synchronizedTest;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * @author zhangjinmiao
 * @create 2019/8/28 19:22
 */
public class Thread01 implements Runnable {

  private int countTicket = 100;
  private static Object obj = new Object();

  public static  boolean flag = true;

  @Override
  public void run() {
    if(flag){//使用同步锁--this
      while(countTicket>0){
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        sale1();
      }
    }else{//使用同步函数
      while(countTicket>0){
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        sale();
      }
    }
  }

  public void sale1(){

//    synchronized(this){ // 不会出错
    synchronized(obj){ // 会出现重复售卖同一张票
      if(countTicket>0){ //------当把这个if判断去掉 最后还是会有两个线程来争夺最后一张票 会挨个执行，数据不会出错，但是逻辑会出错。
        System.out.println("当前线程名字："+Thread.currentThread().getName()+"；出售第"+(100 - countTicket + 1)+"张票。");
        countTicket--;
      }
    }
  }

  public synchronized void sale(){

    if(countTicket>0){
      //卖票
      System.out.println("当前线程名字："+Thread.currentThread().getName()+"；出售第"+(100 - countTicket + 1)+"张票。");
      countTicket--;
    }

  }

}
