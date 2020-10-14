package com.lrw.algorithm.string.simple;

import java.util.*;

/**
 * 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，
 * 如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        //标杆
        int[] charNums = getCharNums(A[0]);
        for (int x=1;x<A.length;x++){
            int[] tempCharNums = getCharNums(A[x]);
            for (int y=0;y<charNums.length;y++){
                if (charNums[y]>tempCharNums[y]){
                    charNums[y] = tempCharNums[y];
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int x=0;x<charNums.length;x++){
            String e = Character.toString((char) ('a'+x));
            while ((charNums[x]--)>0){
                result.add(e);
            }
        }
        return result;
    }

    private int[] getCharNums(String temp){
        int[] nums = new int[26];
        char[] chars = temp.toCharArray();
        for (int x=0;x<chars.length;x++){
            nums[chars[x]-'a']++;
        }
        return nums;
    }

}
