package com.lrw.algorithm.grape.middle;

/**
 * 必经节点集最短路径算法
 * 迪杰斯特拉算法
 */
public class ShortestPathWithReqNode {
    /**
     * 先是Dijkstra算法
     *
     * @param matrix 图的邻接矩阵
     * @param source 开始节点
     * @param des    目标节点
     */
    public int reslove(int[][] matrix,int source,int des) {

        //判断参数是否正确
        if(source < 0 || des < 0 || source >= matrix.length || des >=  matrix.length) {
            System.out.println("错误，顶点不在图中!");
            return IMAX;
        }

        //用来记录某个顶点是否已经完成遍历，即替代优先队列的"移出队列"动作
        boolean[] isVisited = new boolean[ matrix.length];
        //用于存储从s到各个点之间的最短路径长度
        int[] d = new int[ matrix.length];

        //初始化数据
        for(int i=0;i< matrix.length;i++) {
            isVisited[i] = false;
            d[i] = IMAX;
        }
        d[source] = 0; //s到s的距离是0
        isVisited[source] = true; //将s标记为已访问过的

        //尚未遍历的顶点数目，替代优先队列是否为空的判断即Queue.isEmpty()
        int unVisitedNum =  matrix.length;
        //用于表示当前所保存的子路径中权重最小的顶点的索引,对应优先队列中,默认是起点
        int index = source;
        while(unVisitedNum > 0 && index != des) {
            int min = IMAX;
            for(int i=0;i< matrix.length;i++) { //取到第i行的最小元素的索引
                if(min > d[i] && !isVisited[i]) {
                    min = d[i];
                    index = i;
                }
            }
            if(index ==des || unVisitedNum == 0) {
                System.out.print(index); //打印最短路径
            } else {
                System.out.print(index + "=>"); //打印最短路径
            }
            //更新源节点到各个节点的距离
            for(int i=0;i< matrix.length;i++) {
                if(d[index] +  matrix[index][i] < d[i]) {
                    d[i] = d[index] +  matrix[index][i];
                }
            }
            unVisitedNum --;
            isVisited[index] = true;
        }
        return d[des];
    }


    private static int IMAX = 10000; //不连通状态
    public static int[][]  matrix = {
            {0,1,1,IMAX},
            {IMAX,0,1,1},
            {IMAX,1,0,1},
            {IMAX,IMAX,IMAX,0}
    };

    public static void main(String[] args) {
        ShortestPathWithReqNode dijstraAlgorithm = new ShortestPathWithReqNode();
        int start = 2;
        int end = 3;
        System.out.println("------测试------");
        System.out.println("\n从" + start + "到" + end
                + "的距离是:" + dijstraAlgorithm.reslove( matrix, start, end));

        System.out.println("------测试------");
        start = 0;
        end = 3;
        System.out.println("\n从" + start + "到" + end
                + "的距离是:" + dijstraAlgorithm.reslove( matrix, start, end));
    }

}