package com.jimzhang.thread.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 〈〉
 *
 * @author zhangjinmiao
 * @create 2019/8/27 16:23
 */
public class BatchSms {

  public static void main(String[] args) {
    // 1.初始化用户数据
    List<UserEntity> listUserEntity  = init();
    // 2.计算创建多少个线程并且每一个线程需要执行“分批发送短信用户”
    // 每一个线程分批跑多少
    int userThreadPage = 50;
    // 计算所有线程数
    List<List<UserEntity>> splitList = PageUtils.splitList(listUserEntity , userThreadPage);
    int threadSize = splitList.size();
    for (int i=0; i< threadSize; i++) {
      List<UserEntity> list = splitList.get(i);
      UserThread userThread = new UserThread(list);
      // 3.执行任务发送短信
      userThread.start();
    }
  }

  /**
   * 初始化数据
   * @return
   */
  public static List<UserEntity> init(){
    List<UserEntity> list = new ArrayList<>();
    for (int i=1; i < 150; i++) {
      UserEntity userEntity = new UserEntity();
      userEntity.setUserId("userId" + i);
      userEntity.setUserName("userName" + i);
      list.add(userEntity);
    }
    return list;
  }
}
