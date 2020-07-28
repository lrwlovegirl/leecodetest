package com.lrw.algorithm.stack.middle;

import java.util.Stack;

/** 71题
 * https://leetcode-cn.com/problems/simplify-path/
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 输入："/../x"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 */
public class SimplifyPath {
    //输入："/..." 预期输出：”"/..."“  不应该输出”/“ 吗  ？？？？为啥
    public static String simplifyPath(String path) {
        //防止为null
        if (path==null||path.trim().length()==0){
            return "/";
        }
        //防止入参不是以“/”开头
        if (!path.startsWith("/")){
            path ="/" + path ;
        }
        //正式判断
        Stack<String> stack  = new Stack<>();
        //将字符串拆成字符
        String[] temp = path.split("");
        for (int x = 0;x<temp.length;x++){
            //连续2个“/”
            if (temp[x].equals("/")&&stack.size()>0&&stack.peek()!=null&&stack.peek().equals("/")){
                //什么都不做
            }
            //连续2个“.”,表示上一层，stack要出栈到上一个“/”为止
          else   if (temp[x].equals(".")&&x<temp.length-1&&temp[x+1].equals(".")){
                //------》  /a/./b/../../c/
                int count = 0;
                String str = "";
                if (stack.size()>0){
                    str = stack.pop();
                }
                if (str.equals("/")){
                    count++;
                }
                while (((!str.equals("/"))&&(count!=2))||(str.equals("/")&&(count==1))){
                    if (stack.size()>0){
                        str = stack.pop();
                        if (str.equals("/")){
                            count++;
                        }
                    }else {
                        break;
                    }

                }
            }
            //单独1个“.”
            else  if (temp[x].equals(".")&&x<temp.length-1&&!temp[x+1].equals(".")){
               //什么都不做
            }else {
                stack.push(temp[x]);
            }
        }

        StringBuilder sb = new StringBuilder();
        String str = stack.pop();
        while (str!=null){
            sb.append(str);
            if (stack.size()>0){
                str = stack.pop();
            }else {
                break;
            }

        }
        String result = sb.reverse().toString();
        if (result.endsWith("/")){
            result = result.substring(0,result.length()-1);
        }
        if (result.endsWith(".")){
            result = result.substring(0,result.length()-1);
        }
        return result.length()==0?"/":result;
    }


    public static String simplifyPathCorrectly(String path){
        if (path==null||path.trim().length()==0){
            return "/";
        }
        Stack<String> stack = new Stack<>();
        //经过”/“ 拆分之后就只剩下 ”“ 、 ”.“ 、 ”..“的情况了
        String[] temp = path.split("/");
        for (int x=0;x<temp.length;x++){
            //遇到..要出栈
            if (!stack.isEmpty()&&temp[x].equals("..")){
                stack.pop();
            }else if (!temp[x].equals(".")&&!temp[x].equals("")&&!temp[x].equals("..")){
                stack.push(temp[x]);
            }
        }
        if (stack.isEmpty()){
            return "/";
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }



    public static void main(String[] args) {
        System.out.println(simplifyPathCorrectly("/..."));
    }
}
