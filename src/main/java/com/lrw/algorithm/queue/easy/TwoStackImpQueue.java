package com.lrw.algorithm.queue.easy;

import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import java.util.Stack;

/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoStackImpQueue {


    public static void main(String[] args) {
        CQueue obj = new CQueue();
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
}

class CQueue {

    private Stack<Integer> append;

    private Stack<Integer> delete;

    public CQueue() {
        append = new Stack<>();
        delete = new Stack<>();
    }

    //peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
    public void appendTail(int value) {
        append.push(value);
    }

    public int deleteHead() {
        if (append.empty()) {
            return -1;
        }
        while (!append.empty()) {
            Integer value = append.pop();
            delete.push(value);
        }
        //出栈
        Integer result = delete.pop();
        while (!delete.empty()) {
            Integer pop = delete.pop();
            append.push(pop);
        }
        return result;
    }
}

