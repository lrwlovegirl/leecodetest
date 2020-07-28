package com.lrw.algorithm.string.simple;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LastWordLen {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了40.25%的用户
     * 内存消耗 :38.2 MB, 在所有 Java 提交中击败了6.38%的用户
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s==null||s.trim().length()==0){
            return 0;
        }
        String[] temp = s.split(" ");
        return  temp[temp.length-1].length();
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了6.38%的用户
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        if (s==null||s.length()==0||s.trim().length()==0){
            return 0;
        }
        s = s.trim();
        char[] chars = s.toCharArray();
        int count =0 ;
        for (int len = chars.length-1;len>=0;len--){
            if (chars[len]!=' '){
                count++;
            }else {
                break;
            }
        }
        return count;
    }




    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("a"));
    }
}
