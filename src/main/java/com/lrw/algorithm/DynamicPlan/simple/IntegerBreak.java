package com.lrw.algorithm.DynamicPlan.simple;
//整数拆分

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Author liurenwang
 * time   2020-7-30
 */
public class IntegerBreak {
    //动态规划问题
    public static int integerBreak(int n) {
        int[] dp = new int[n];
        //定义边界
        dp [2] = 1;
        dp [3] = 2;
        //转换方程 f(k) = f(k-1)*k,至于f(k-1)是否要继续拆分，要看f(k-1)*k大，还是继续拆分大
       for (int i=2 ;i<n ;i++){ //从2份开始拆分，控制份数
          int currentMax = 0 ;
          for (int j=1;j<i;j++){ //从1开拆
              currentMax = Math.max(currentMax, Math.max(j * (i - j), j * dp[i - j]));
          }
          dp[i] = currentMax;
       }
        return dp[n-1];
    }
    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }




    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
