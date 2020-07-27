package com.lrw.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsSubsequence {

    //失败，本解法无法处理 leetocde  leeetocde 这种形式
    public static boolean isSubsequence(String s, String t) {
        //简单判断
        if (s == null) return true;
        if (s.length() > t.length()) return false;
        if (t.contains(s)) return true;
        //去除掉t中的某些字符
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        for (int i = 0; i < chars.length; i++) {
            int x = t.indexOf(String.valueOf(chars[i]));
            if (x == -1) {//没找到这个字符
                return false;
            }
            //有这个字符,且位置大于前一个字符
            t = t.replaceFirst(String.valueOf(chars[i]), "");
            if (x < list.get(list.size() - 1)) {
                return false;
            }
            list.add(x);
        }
        return true;
    }

    //双指针

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了47.34%的用户
     * 内存消耗：37.4 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static boolean isSubsequence1(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }


    public static void main(String[] args) {
        System.out.println(isSubsequence("rjufvjafbxnbgriwgokdgqdqewn", "mjmqqjrmzkvhxlyruonekhhofpzzslupzojf" +
                "uoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuakt" +
                "upfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnzn" +
                "ddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifin" +
                "ccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkg" +
                "wafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjf" +
                "xtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctj" +
                "mkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"));

    }
}
