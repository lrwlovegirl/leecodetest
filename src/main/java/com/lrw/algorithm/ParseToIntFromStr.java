package com.lrw.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入: "42"
 * 输出: 42
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 */
public class ParseToIntFromStr {
    public static int myAtoi(String str) {
        if (null == str||str.length()==0) {
            return 0;
        }
        //去除所有空格
        str = str.replace(" ", "");
        if (str.contains(".")){
           str = str.split("\\.")[0];
           if (str.length()==0){
               return 0;
           }
        }

        //定义匹配正则,负的0-9 ,正的 0-9
        Pattern pattern = Pattern.compile("[-+]??[0-9]++");

        //这里是核心,平常调用isNum.matches(str)这个方法，是将字符串完全匹配正则，即
        //要求字符串全是数字，则返回正确，例如，22aa,如果调用matches 就会返回false，
        //但是isNum.lookingAt() 这个函数，会比较开头是否符合正则，22aa 调用lookingAt() 就会返回true,
        //因为，开头就是数字
        Matcher isNum = pattern.matcher(str);
        if (isNum.lookingAt()) {//表明开头是数字
            //isNum.end() 返回符合规则的最后一个字符的位置
            try {
                str = str.substring(0, isNum.end());
                int result = Integer.parseInt(str);
                return result;
            } catch (Exception e) {
                return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  -0012a42"));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(".1"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("41a93 with words"));
        System.out.println(myAtoi("4193 23 words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }
}
