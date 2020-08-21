package com.lrw.algorithm.grape.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * Author liurenwang
 * time 2020-8-4
 */
public class Courser {

    //这道题一看就是图的遍历
    public boolean canFinish(int numCourses, int[][] prerequisites) {//numCourses个结点的有向图
        //n条边
        int n = prerequisites.length;
        //邻接表
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        ArrayList<Integer>[] adjacencyList = new ArrayList[numCourses];
        //入度数组，inDegree[i]的值表示节点i的入度
        int[] inDegree = new int[numCourses];
        //先由边的集合构建邻接表
        for(int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
        //???
        for(int[] p : prerequisites) {
            adjacencyList[p[1]]    .add(p[0]);
            inDegree[p[0]]++;
        }
        for (int x= 0;x<prerequisites.length;x++){
            int[] prerequisite = prerequisites[x];
            adjacencyList[prerequisite[1]].add(prerequisite[0]);

        }

        //拓扑排序判断是不是DAG
        return topologicalSort(adjacencyList,inDegree,numCourses);
    }
    private boolean topologicalSort(ArrayList<Integer> [] adjacencyList,int [] inDegree,int n){//邻接表和入度数组
        int cnt = 0; // 保存能取出的结点数目
        // 定义队列保存入度为零的结点
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < n; i++) {
            // 入度为零的结点入队
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 取出入度为零的结点，更新其余结点的入度
        while(!queue.isEmpty()) {
            int i = queue.poll(); // 取出队头元素
            cnt++; // 计数加一
            for(int child_of_i : adjacencyList[i]) {
                inDegree[child_of_i]--;
                if(inDegree[child_of_i] == 0) {
                    queue.offer(child_of_i);
                }
            }
        }
        return cnt == n;
    }
    //深度优先遍历
    public static void test(int numCourses,int[][] prerequisites ){
        int [] visist = new int[numCourses];//开节点个数数组，表示该节点是否被访问过了 0 表示没有访问过，1表示访问过
        // 定义一个数组来存储课程的入度
        int[] indegree = new int[numCourses];
        // 定义一个队列用来排序
        Queue<Integer> queue = new LinkedList<>();
        //这句话是说，在前面的课，会有一个前置课程 比如 [2,1] [1,0]
        for (int[] arr : prerequisites){ //arr = [2,1]
            indegree[arr[0]]++;
        }

        // 将所有入度为0的课程入队(表示学习此课程不需要前置课程), 然后将入度标记为-1，防止后面重复入队
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0)
            {
                queue.add(i);
                indegree[i] --;
            }
    }


}
