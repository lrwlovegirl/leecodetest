package com.lrw.algorithm.binarySearch.middle;

/**
 * desc:二分查找
 * Author :liurenwang
 * time: 2020/11/27
 * version: jdk 1.8
 */
public class BinarySearch {
    //递归实现
    public int commonBinarySearch(int[] array, int key, int low, int hight) {
        //比最小的都小或者比最大的都大
        if (key < array[low] || key > array[hight]) {
            return -1;
        }
        //初始化中间位置
        int middle = (low + hight) / 2;
        if (array[middle] > key) {
            return commonBinarySearch(array, key, low, middle - 1);
        } else if (array[middle] < key) {
            return commonBinarySearch(array, key, middle + 1, hight);
        } else {
            return middle;
        }
    }


    //迭代实现
    public int commonBinarySearch(int[] array,int key){
        int low = 0;
        int hight = array.length-1;
        int middle = 0;
        if (key<array[low]||key>array[hight]){
            return -1;
        }
        while (low<=hight){
            middle = (low+hight)/2;
            if (array[middle]>key){
                hight = middle-1;
            }else if (array[middle]<key){
                low = middle+1;
            }else {
                return middle;
            }
        }
        //没找到
        return -1;
    }


}
