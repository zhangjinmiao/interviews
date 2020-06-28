package com.jimzhang.thread.demo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * @author zhangjinmiao
 * @create 2019/8/27 15:55
 */
public class UserThread extends Thread {

  private List<UserEntity> list;

  /**
   * 通过构造函数 传入每个线程需要执行的发送短信内容
   * @param list
   */
  public UserThread(List<UserEntity> list) {
    this.list = list;
  }

  /**
   * 分批发送短信
   */
  @Override
  public void run() {
    for (UserEntity userEntity : list) {
      System.out.println("threadName:" + Thread.currentThread().getName() + "-学员编号:" + userEntity.getUserId() + "-学员名称:" + userEntity.getUserName());
      // 调用发送短信具体代码
    }
  }




}
