package com.lrw.algorithm.array.simple;

/**
 * 剑指offer第4题，在二维数组中查询某个数字是否存在
 * 二维数组特点： 从左往右 无规律变大，从上往下，无规律变大
 * 2 4 5 6
 * 3 5 6 8
 * 4 6 7 8
 * 查询10
 */
public class FindNumInTwoArray {

    public static boolean isExist(int[][] arr, int num) {
        if (arr == null) return false;
        int widthLen = arr.length; //几行
        int heightLen = 0;
        if (widthLen>=1){
            heightLen =  arr[0].length;//几列
        }
        //比最大的还大 或者比 最小的还小
        if (arr[0][heightLen-1]<num||arr[widthLen-1][0]>num){
            return false;
        }
        //找寻最上层
        int [] nums = arr[widthLen-1];
        int column = 0; //要查找的数应该所在的列
        for (int x=0;x<nums.length;x++){
            if (nums[x]==num){
                return true;
            }else if (nums[x]>num){
                column = x;
                break;
            }
        }
        //找到了列
        for (int i=widthLen-1 ;i>=0;i--){
            if (num==arr[i][column]){
                return true;
            }
            if (num >arr[i][column]){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] arr  = new int [][]{{4,6,7,8},{3,5,6,8},{2,4,5,6}};
        System.out.println(isExist(arr,10));
    }


}
