package com.lrw.algorithm.other;

/**
 * 矩阵中的路径，剑指offer第12题
 * Author ： liurenwang
 * time :2020-8-28
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意
 * 一格开始，每一步可以 在矩阵中向上下左右移动一格，如果一条路径精工了矩阵的某一格，那么该路径不能再次进入该格子
 * a  b  t  g
 * c  f  c  s
 * j  d  e  h
 */
public class PathInMatrix {


    public static boolean resolve(char[][] array, String str) {
        boolean flag = false; //默认返回值
        //校验
        if (str == null || str.isEmpty() || array == null) {
            return flag;
        }

        //获取第一个字符
        char[] chars = str.toCharArray();
        char first = chars[0];
        //找到字符在二维数组中的位置
        int x = 0, y = 0;
        for (; x < array.length; x++) {
            char[] oneChar = array[x];
            for (; y < oneChar.length; y++) {
                if (first == oneChar[y]) {
                    flag = true ; //第一个字符找到了
                    break;
                }
            }
        }
        //如果连第一个字符都没找到，直接就返回false
        return flag&&hashPath(x,y,array,chars[1]);
    }

    public static boolean hashPath(int row,int col,char[][] array,char ch) {



        return false;
    }


    public static void main(String[] args) {
        String str = "bfce";
        char[][] array = new char[][]{{'j', 'd', 'e', 'h'}, {'c', 'f', 'c', 's'}, {'a', 'b', 't', 'g'}};
        System.out.println(resolve(array, str));
    }

}
