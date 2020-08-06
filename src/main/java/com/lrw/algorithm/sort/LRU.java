package com.lrw.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class LRU {
    private int theArray[];
    private int back; //队尾
    private int currentSize; //现在队列中存放元素的个数
    private int maxSize = 5; //队列中能存放元素的最大个数

    public LRU() {
        theArray = new int[maxSize];
        back = 0;
        currentSize = 0;
    }

    public void queue(int a[]) {
        for (int i = 0; i < a.length; i++) {
            enQueue(a[i]);
        }
    }

    public void enQueue(int x) { //入队
        beUsed(x);
        if (currentSize < maxSize) {
            theArray[back] = x;
            back++;
            currentSize++;
        } else if (currentSize == maxSize) {
            //移动
            for (int i = 0; i < maxSize - 1; i++) {
                theArray[i] = theArray[i + 1];
            }
            theArray[maxSize - 1] = x;
        }
        for (int i = 0; i < currentSize; i++) {
            System.out.print(theArray[i]);
        }
        System.out.println();
    }

    public void beUsed(int x) {
        //判断是否已存在该页号，若存在，删除已有的
        for (int i = 0; i < currentSize; i++) {
            if (theArray[i] == x) {
                for (int j = i; j < currentSize - 1; j++) {
                    theArray[j] = theArray[j + 1];
                }
                currentSize--;
                back--;
            }
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        int a[] = {4, 7, 0, 7, 1, 0, 1, 2, 1, 2, 6};
        lru.queue(a);
        System.out.println("#########################################");
        LRUTest.Test(a);
    }

    static class LRUTest {
        public static List<Integer> list = new ArrayList();
        public static int currentSize = 0;
        public static int maxSize = 5;

        public static void Test(int[] a) {
            for (int i = 0; i < a.length; i++) {
                List<Integer> queue = queue(a[i]);
                for (int x =0;x<queue.size();x++){
                    System.out.print(queue.get(x));
                }
                System.out.println();
            }

        }

        public static List<Integer> queue(Integer x) {
            //入队元素要先判断是否在队列中，如果在的话就，是最后一个元素就不要动，如果不是最后一个，则删除，再新增
            if (list.contains(x)) {
                if (list.get(list.size() - 1) == x) {
                    //什么都不做
                } else {
                    boolean remove = list.remove(x);
                    list.add(x);
                }
            } else {
                if (currentSize < maxSize) {
                    list.add(x);
                    currentSize++; //入队
                } else {
                    //删除第一个元素
                    list.remove(list.get(0));
                    list.add(x);
                }
            }
            return list;
        }

    }

}
