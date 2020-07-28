package com.lrw.algorithm.string.simple;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  Author liurenwang
 * 答案在idea中执行不对，s.trim()函数不会起作用，提交到leecode上就可以
 * 执行用时 :3 ms, 在所有 Java 提交中击败了71.20%的用户
 * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了5.41%的用户
 *
 */
public class ReverseStrWord {
    public static String reverseWords(String s) {
      //校验参数
      if (null==s||s.trim().length()==0) {
          return "";
      }
      //s = s.replace((char) 12288, ' ');
      s = s.trim(); //去除两端空格
      String[] temp = s.split(" ");//按空格拆分
      String[] middleArray = new String[temp.length];
      StringBuffer stringBuffer = new StringBuffer();
      for (int x=temp.length-1,j=0;x>=0;x--,j++){
          if (temp[x].trim().length()==0||" ".equals(temp[x])){//防止出现第三种情况
              continue;
          }
          middleArray[j]=temp[x]+" ";
          if (middleArray[j].trim().length()>0){
              StringBuffer sb = new StringBuffer(middleArray[j]);
              stringBuffer.append(sb.toString());
          }
      }
      String result = stringBuffer.toString().trim();//去除最后一个空格
      return result;
    }

    public static void main(String[] args) {
        //System.out.println(reverseWords("a good   example"));
        System.out.println("".length());
    }
}
