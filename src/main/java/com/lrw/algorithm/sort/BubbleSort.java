package com.lrw.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 冒泡排序以及优化
 */
public class BubbleSort {

    private static List<Integer> numList = new ArrayList<>();
    static {

        numList.add(6);
        numList.add(4);
        numList.add(7);
        numList.add(5);
        numList.add(1);
        numList.add(3);
        numList.add(2);
    }

     /**
      *未优化的冒泡排序，时间复杂度O(n2),稳定
      * 注意点
      * 1.外层for循环是按照长度-1
      * 2.内层for循环是起始值为0
      * 3.内层for循环是按照length-1-x算起
      * 4.内层判断是按照相邻2比较即 y和y+1算起
      * @return
     */
    public static void bubbleSortTest(List<Integer> numList){
        int len = numList.size();
        for (int x=0;x<len-1;x++){
            for (int y=0;y<len-x-1;y++){
               int front = numList.get(y);
               int rear = numList.get(y+1);
               if (front<rear){
                   int temp = front ;
                   numList.set(y,rear);
                   numList.set(y+1,temp);
               }
            }
            System.out.println("第"+(x+1)+"次遍历："+numList);
        }
    }

    /**
     * 第一次优化后的冒泡排序
     * 1.如果在某一趟已经排序好了，那么就不需要再排序了
     */
  public static void optimizBubbleSortTest(List<Integer> numList){
        int len = numList.size();
        for (int x=0;x<len-1;x++){
          int count  = 1;//标志位
          for (int y=0;y<len-x-1;y++){
              int front = numList.get(y);
              int rear = numList.get(y+1);
              if (front<rear){
                  count = 0;
                  int temp = front ;
                  numList.set(y,rear);
                  numList.set(y+1,temp);
              }
          }
          System.out.println("第"+(x+1)+"次遍历："+numList);
          if (count==1){
              return;
          }
      }
  }

    /**
     *第二次优化后的冒泡排序
     * 1.前期某些元素已经不需要移动了，让内层循环不需要再进行判断
     * @param numList
     */
  public static void optimizBubbleSortTest2(List<Integer> numList){
      int len = numList.size()-1;
      int postion = 0;//记录最后一次交换的位置
      for (int x=0;x<numList.size()-1;x++){
          int count  = 1;//标志位
          for (int y=0;y<len;y++){
              int front = numList.get(y);
              int rear = numList.get(y+1);
              if (front<rear){
                  count = 0;//移动了位置
                  int temp = front ;
                  numList.set(y,rear);
                  numList.set(y+1,temp);
                  postion = y;
              }
          }
          len  =  postion;
          System.out.println("第"+(x+1)+"次遍历："+numList);
          if (count==1){
              return;
          }
      }
  }





    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(4);
        numList.add(3);
        numList.add(1);
        numList.add(2);
        System.out.println("修改前：");
        System.out.println(numList);
        System.out.println("优化前排序后（常规冒泡排序）：");
        bubbleSortTest(numList);
        List<Integer> numList2 = new ArrayList<>();
        numList2.add(5);
        numList2.add(4);
        numList2.add(3);
        numList2.add(1);
        numList2.add(2);
        System.out.println("优化后排序后(第一次优化冒泡排序)：");
        optimizBubbleSortTest(numList2);
        System.out.println("优化后排序后(第二次优化冒泡排序)：");
        List<Integer> numList3 = new ArrayList<>();
        numList3.add(5);
        numList3.add(4);
        numList3.add(3);
        numList3.add(1);
        numList3.add(2);
        optimizBubbleSortTest2(numList3);

    }


}
