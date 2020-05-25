package com.lrw.algorithm;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    /**
     * 执行用时 :10 ms, 在所有 Java 提交中击败了6.72%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.48%的用户
     */
    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if ("".equals(s)||s.trim().length() == 0) {
            return true;
        }
        Stack<String> stack = new Stack<String>();
        String[] temp = s.split("");
        for (int x = 0; x < temp.length; x++) {
            if ("".equals(temp[x])) {
                continue;
            }
            try {
                if ("(".equals(temp[x]) || "[".equals(temp[x]) || "{".equals(temp[x])) {
                    stack.push(temp[x]);
                } else if (")".equals(temp[x])) {
                    if (!("(".equals(stack.pop()))) {
                        return false;
                    }
                } else if ("]".equals(temp[x])) {
                    if (!"[".equals(stack.pop())) {
                        return false;
                    }
                } else if ("}".equals(temp[x])) {
                    if (!"{".equals(stack.pop())) {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("((){}[]"));
    }


}
