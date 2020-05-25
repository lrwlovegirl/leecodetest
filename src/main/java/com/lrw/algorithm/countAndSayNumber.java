package com.lrw.algorithm;

/**
 * 38. 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 */
public class countAndSayNumber {
    //1<=n<=30
    public  static String countAndSay(int n) {
        if (n<=0){return "";}
        String str = "1";
        for (int x = 2 ;x<=n;x++){

        }
        return str;
    }

    public static void main(String[] args) {

    }


}
