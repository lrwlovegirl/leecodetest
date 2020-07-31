package com.lrw.algorithm.array.simple;


/**
 *魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法
 * 找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author liurenwang
 * time 2020-7-31
 */
public class MagicIndex {
    //暴力破解
    //执行用时：1 ms, 在所有 Java 提交中击败了47.45%的用户
    //内存消耗：40.5 MB, 在所有 Java 提交中击败了75.76%的用户
    public static int findMagicIndex(int[] nums) {
      for (int x =0;x<nums.length;x++){
          if (x==nums[x]){
              return x;
          }
      }
      return  -1;
    }

    //废弃这种方法，因为命中以后也得向前看有没有符合情况的，最好情况时间复杂度O(n/2),没有命中就向前看，左边都没有，就遍历右边
    //因为是有序的，所以可以二分法，最坏情况也是O(n),
    public static int findMagicIndex2(int[] nums) {
        boolean flag = false;//是否命中
        int result = 0;//如果命中就返回这个结果
        int low = 0;
        int hight = nums.length-1;
        while (low<=hight){
            int middle = (low+hight)/2;
            if (middle == nums[middle]){
               flag = true;
               result = middle;
               //命中以后就往前看，是否还有符合要求的
            }
        }
        

        return  flag?result:-1;
    }






    public static void main(String[] args) {
        int [] nums = new int[]{0,2,3,4,5};
        System.out.println(findMagicIndex(nums));
    }
}
