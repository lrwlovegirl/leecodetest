package com.lrw.algorithm.array.simple;

/**
 * Desc:   941. 有效的山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * Author: liurenwang
 * time: 9:44 2020/11/3
 */
public class ValidMountainArray {


    public static boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        boolean flag = true;
        boolean mark = true;
        for (int x=1;x<A.length;x++){
            if (flag){
                if (A[x]>A[x-1]){
                    mark =false ;
                    continue;
                }else if (A[x]==A[x-1]){
                    return false;
                }else {
                    flag =false;
                }
            }else {
                if (A[x]<A[x-1]){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true&&(flag==false?true:false)&&(mark ==false?true:false);
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{3,5,5}));
    }


}
