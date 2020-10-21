package com.lrw.algorithm.string.simple;

/**
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * https://leetcode-cn.com/problems/long-pressed-name/
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 */
public class IsLongPressedName {
    //双指针
    public static boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        int i=0,j=0;
        while (j<typed.length()){
            if (i<name.length()&&typed.charAt(j)==name.charAt(i)){
                i++;
                j++;
                continue;
            }else if (j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
                continue;
            }else {
                return false;
            }
        }
        return i==name.length();
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
    }
}
