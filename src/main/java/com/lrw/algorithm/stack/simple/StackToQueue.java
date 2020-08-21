package com.lrw.algorithm.stack.simple;

import java.util.Stack;

/**
 * 剑指offer第4题，两个栈实现一个队列
 * Author:liurenwang
 * time 2020-8-21
 */
public class StackToQueue {

      private static Stack<Integer> stack = new Stack();
      private static Stack<Integer> copyStack = new Stack();

      public static void resolve(){

      }
      //入队
      public static int push(int num){
          Integer result = stack.push(num);
          return result;
      }
      //出队
      public static int get(){
          while (!stack.isEmpty()){
              copyStack.push(stack.pop());
          }
          return copyStack.pop();
      }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(get());
        System.out.println(get());
        System.out.println(get());
    }




}
