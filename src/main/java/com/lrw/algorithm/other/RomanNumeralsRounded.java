package com.lrw.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入: "III"
 * 输出: 3
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 */
public class RomanNumeralsRounded {

    private static Map<String,Integer> map = new HashMap<String,Integer>();
    static {
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
    }


    //显然，这不是什么好的办法
    public static int romanToInt(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int result = 0;
        if (s.contains("IV")) {
            result = result + 4;
            s = s.replace("IV", "");
        }
        if (s.contains("IX")) {
            result = result + 9;
            s = s.replace("IX", "");
        }
        if (s.contains("XL")) {
            result = result + 40;
            s = s.replace("XL", "");
        }
        if (s.contains("XC")) {
            result = result + 90;
            s = s.replace("XC", "");
        }
        if (s.contains("CD")) {
            result = result + 400;
            s = s.replace("CD", "");
        }
        if (s.contains("CM")) {
            result = result + 900;
            s = s.replace("CM", "");
        }

        String[] temp = s.split("");
        for (int x = 0; x < temp.length; x++) {
            if ("".equals(temp[x])){
                continue;
            }
            String vo = temp[x];
            int middle = 0;
            switch (vo) {
                case "I": {
                    middle = 1;
                    break;
                }
                case "V": {
                    middle = 5;
                    break;
                }
                case "X": {
                    middle = 10;
                    break;
                }
                case "L": {
                    middle = 50;
                    break;
                }
                case "C": {
                    middle = 100;
                    break;
                }
                case "D": {
                    middle = 500;
                    break;
                }
                case "M": {
                    middle = 1000;
                    break;
                }
            }
            result = result + middle;
        }
        return result;
    }


    public static  int romanToInt2(String s){
        if (s==null||s.trim().length()==0){
            return 0;
        }
        int result = 0;
        for (int x=0;x<s.length();x++){
            String middle = null;
            if (x+2>s.length()){
                middle =  s.substring(x,s.length());
            }else {
                middle =  s.substring(x,x+2);
            }
            if (null!=map.get(middle)){
                result = result+map.get(middle);
                x++;
            }else if (null!=map.get(middle.substring(0,1))){
                result = result+map.get(middle.substring(0,1));
            }else {
                result =result+0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt2("IX"));
    }

}
