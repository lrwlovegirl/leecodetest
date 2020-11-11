package com.lrw.algorithm.array.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    //回溯
    public static List<String> letterCombinations(String digits) {
        if (digits == null||"".equals(digits.trim())) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        getResultList(map, result, digits, 0, new StringBuffer());
        return result;
    }

    private static void getResultList(Map<Character, String> map, List<String> result, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            result.add(stringBuffer.toString());
        } else {
            char c = digits.charAt(index);
            String s = map.get(c);
            for (int x = 0; x < s.length(); x++) {

                stringBuffer.append(s.charAt(x));
                getResultList(map,result,digits,index+1,stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        for (String s :strings){
            System.out.println(s);
        }
    }

}
