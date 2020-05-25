package com.lrw.algorithm;

public class RemoveElements {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了5.68%的用户
     */
    public static int removeElement(int[] nums, int val) {
         int current = 0 ;
         int index =0;
         int len = nums.length;
         if (len==0){
             return 0;
         }
         for (index =0;index<nums.length;index++){
             if (nums[index]==val){
                 for (int x = len-1;x>index;x--){
                     if (nums[x]!=val){
                         int temp = nums[index];
                         nums[index] = nums[x];
                         nums[x] = temp;
                         current++;
                         break;
                     }
                 }
             }else {
                 current++;
             }

         }
         return current;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(removeElement(nums,1));


    }
}
