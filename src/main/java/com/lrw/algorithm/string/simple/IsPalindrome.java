package com.lrw.algorithm.string.simple;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {


    public static boolean isPalindrome(String s) {
        //A man, a plan, a canal: Panama
        //去除其他字符
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int x=0,y=actual.length()-1;x<=y;x++,y--) {
            if (actual.charAt(x) != actual.charAt(y)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
