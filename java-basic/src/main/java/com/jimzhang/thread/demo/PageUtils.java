package com.jimzhang.thread.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 〈分页工具〉
 *
 * @author zhangjinmiao
 * @create 2019/8/27 16:04
 */
public class PageUtils {

  /**
   * list 集合分批切割
   * @param list      切割集合
   * @param pageSize  分页长度
   * @param <T>       分页数据
   * @return
   */
  public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
    int listSize = list.size(); // 总条数
    int page = (listSize + (pageSize - 1)) / pageSize;  // 总页数
    List<List<T>> listArray = new ArrayList<>();
    for (int i=0; i < page; i++) {
      List<T> subList = new ArrayList<>();
      for (int j=0; j < listSize; j++) {
        int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
        if (pageIndex == (i + 1)) {
          subList.add(list.get(j));
        }
        if ((j + 1) == ((j + 1) * pageSize)) {
          break;
        }
      }
      listArray.add(subList);
    }
    return listArray;
  }

}
