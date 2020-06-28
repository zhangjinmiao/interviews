package com.jimzhang.thread.create;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br> 〈创建线程：使用线程池〉
 *
 * @author zhangjinmiao
 * @create 2019/8/18 17:28
 */
public class ThreadDemo05 {

  public static void main(String[] args) throws Exception {
    //1. 创建线程池
    ExecutorService pool = Executors.newFixedThreadPool(5);

    List<Future<Integer>> list = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      Future<Integer> future = pool.submit(new Callable<Integer>(){

        @Override
        public Integer call() throws Exception {
          int sum = 0;

          for (int i = 0; i <= 100; i++) {
            sum += i;
          }

          return sum;
        }

      });

      list.add(future);
    }

    pool.shutdown();

    for (Future<Integer> future : list) {
      System.out.println(future.get());
    }



		/*ThreadPoolDemo tpd = new ThreadPoolDemo();

		//2. 为线程池中的线程分配任务
		for (int i = 0; i < 10; i++) {
			pool.submit(tpd);
		}

		//3. 关闭线程池
		pool.shutdown();*/
  }

  //	new Thread(tpd).start();
  //	new Thread(tpd).start();

}

class ThreadPoolDemo implements Runnable{

  private int i = 0;

  @Override
  public void run() {
    while(i <= 100){
      System.out.println(Thread.currentThread().getName() + " : " + i++);
    }
  }

}