package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速排序
 */
public class quickSort {

    private static int[] arr={5,23,25,56,1,3,98,45};

    /**
     * 快速排序实现方法
     */
    private static int[] quickSortTest(int arr[],int left,int right){
       if (right<left){//递归出口
           return arr;
       }
       //选一个基准
       int base = arr[left];
       int i = left;
       int j = right;
       while (i!=j){
           //必须从右往左开始
           while (j>i&&arr[j]>=base){//小于标杆且没到标杆
               j--;
           }
           while (i<j&&arr[i]<=base){
               i++;
           }
           //程序执行到这，说明找到了比标杆大的和比标杆小的，交换他俩的位置
           int  temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
       }
       //执行到i==j时，需要将arr[i]与base交换位置，这样在arr[i]之前的都是比base小的，之后的都是比base大的
        arr[left] = arr[i];
        arr[i] = base;
        //执行完再排序左边的
        quickSortTest(arr,left,i-1);
        quickSortTest(arr,j+1,right);
        return arr;
    }




    public static void main(String[] args) {
        quickSortTest(arr,0,arr.length-1);
        for (int x=0;x<arr.length;x++){
            System.out.print(arr[x]+" ");
        }

    }



}
