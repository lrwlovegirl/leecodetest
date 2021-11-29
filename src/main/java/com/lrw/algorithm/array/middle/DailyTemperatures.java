package com.lrw.algorithm.array.middle;
//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。

import java.util.Arrays;

/**
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {


    //找出下一个比当前数大的数字，并输出其位置
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        if (length == 1){
            return new int[]{0};
        }
        int[] result = new int[length];
        //暴力解法
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            for (int j = i+1;j<length;j++){
                if (temperatures[j]>temperature){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = dailyTemperatures(new int[]{30,60,90});
        for (int anInt : ints) {
            System.out.print(anInt+"、");
        }
    }
}
