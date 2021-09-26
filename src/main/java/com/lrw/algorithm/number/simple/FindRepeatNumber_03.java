package com.lrw.algorithm.number.simple;
//剑指offer第3题，查出重复的数字
public class FindRepeatNumber_03 {


    public static int findRepeatNumber(int[] nums) {
        for (int x=0; x<nums.length;x++){
            int num = nums[x];

            int temp = nums[num];
            if (num == temp ){
                return temp;
            }
            nums[num] = num;
            nums[x] = temp;
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));
    }
}
