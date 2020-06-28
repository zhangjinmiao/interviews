package com.jimzhang.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 〈一句话功能简述〉<br> 〈创建线程：实现Callable接口〉
 *
 * @author zhangjinmiao
 * @create 2019/8/18 17:22
 */
public class ThreadDemo04 {

  public static void main(String[] args) {
    ThreadDemo td = new ThreadDemo();

    //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
    FutureTask<Integer> result = new FutureTask<>(td);

    new Thread(result).start();

    //2.接收线程运算后的结果
    try {
      Integer sum = result.get();  //FutureTask 可用于 闭锁
      System.out.println(sum);
      System.out.println("------------------------------------");
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }

}

class ThreadDemo implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    int sum = 0;

    for (int i = 0; i <= 100000; i++) {
      sum += i;
    }

    return sum;
  }

}