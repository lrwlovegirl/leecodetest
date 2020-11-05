package com.lrw.other.test;

import java.util.*;

public class ShortestCItyPath {

    public static Map<String, Boolean> visitedMap = new HashMap<>();

    public static List<String> resolve(List<CityFiber> cityFiberList, List<String> bjNodeId) {
        //构建二维矩阵
        //1。 首先要知道涉及到几个城市，这里直接给出
        int size = 5;
        int[][] matrix = new int[size][size];
        //2.填充二维数组，将权重写进去
        List<Map<String, Map<String, Integer>>> list = new ArrayList<>();
        for (int x = 0; x < cityFiberList.size(); x++) {
            //city 和 city连接的其他城市集合
            CityFiber cityFiber = cityFiberList.get(x);

            Map<String, Map<String, Integer>> map = new HashMap<>(); //(id,(其他城市id,权重))
            List<City> cityList = cityFiber.cityList;
            //这里表明每个节点对其他节点联通
            Map<String, Integer> realWeight = new HashMap<>();
            cityList.forEach(city -> {
                realWeight.put(city.id, 1);
            });
            map.put(cityFiber.city.id, realWeight);
            list.add(map);
        }
        test(list, "A", "B");
        //找最短的
        List<List<String>> newResult = new ArrayList<>();
        for (List<String> temp : result) {
            if (temp.containsAll(bjNodeId)) {
                newResult.add(temp);
            }
        }
        int pos = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < newResult.size(); i++) {
            if (newResult.get(i).size() < len) {
                len = newResult.get(i).size();
                pos = i;
            }
        }

        return result.get(pos);

    }


    /**
     * 先是Dijkstra算法
     *
     * @param matrix 图的邻接矩阵
     * @param source 开始节点
     * @param des    目标节点
     */
    public int reslove(int[][] matrix, int source, int des) {

        //判断参数是否正确
        if (source < 0 || des < 0 || source >= matrix.length || des >= matrix.length) {
            System.out.println("错误，顶点不在图中!");
            return Integer.MAX_VALUE;
        }
        //用来记录某个顶点是否已经完成遍历，即替代优先队列的"移出队列"动作
        boolean[] isVisited = new boolean[matrix.length];
        //用于存储从s到各个点之间的最短路径长度
        int[] d = new int[matrix.length];
        //初始化数据
        for (int i = 0; i < matrix.length; i++) {
            isVisited[i] = false;
            d[i] = Integer.MAX_VALUE;
        }
        d[source] = 0; //s到s的距离是0
        isVisited[source] = true; //将s标记为已访问过的

        //尚未遍历的顶点数目，替代优先队列是否为空的判断即Queue.isEmpty()
        int unVisitedNum = matrix.length;
        //用于表示当前所保存的子路径中权重最小的顶点的索引,对应优先队列中,默认是起点
        int index = source;
        while (unVisitedNum > 0 && index != des) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++) { //取到第i行的最小元素的索引
                if (min > d[i] && !isVisited[i]) {
                    min = d[i];
                    index = i;
                }
            }
            if (index == des || unVisitedNum == 0) {
                System.out.print(index); //打印最短路径
            } else {
                System.out.print(index + "=>"); //打印最短路径
            }
            //更新源节点到各个节点的距离
            for (int i = 0; i < matrix.length; i++) {
                if (d[index] + matrix[index][i] < d[i]) {
                    d[i] = d[index] + matrix[index][i];
                }
            }
            unVisitedNum--;
            isVisited[index] = true;
        }
        return d[des];
    }

    public static void test(List<Map<String, Map<String, Integer>>> list, String sourceId, String desId) {

        int source = 0;
        int des = 0;
        for (int x = 0; x < list.size(); x++) {
            Map<String, Map<String, Integer>> integerMapMap = list.get(x);
            String next = integerMapMap.keySet().iterator().next();
            if (next.equals(sourceId)) {
                source = x;
            } else if (next.equals(desId)) {
                des = x;
            }
        }

        Map<String, Integer> weightMap = new HashMap<>();
        /**
         * A,B,C,D,E
         */
        List<String> idList = new ArrayList<>();
        list.forEach(map -> {
            idList.add(map.keySet().iterator().next());
        });

        //获取目标节点的id值 :D
        String desIdChar = list.get(des).keySet().iterator().next();
        String sourceIdChar = list.get(source).keySet().iterator().next();
        System.out.println("源节点Id为" + sourceIdChar + ",目标节点Id为：" + desIdChar);
        /**
         * A: (A:0)
         *    (B:1)
         *    (C:1)
         */

        /**
         * A:0
         * B:1
         */
        for (int x = 0; x < list.size(); x++) {
            Map<String, Map<String, Integer>> integerMapMap = list.get(x);
            String key = integerMapMap.keySet().iterator().next();
            Map<String, Integer> integerIntegerMap = integerMapMap.get(key);
            Iterator<String> iterator = integerIntegerMap.keySet().iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                String newKey = key + "->" + next;
                int weight = integerIntegerMap.get(next) == null ? 99999 : integerIntegerMap.get(next);
                weightMap.put(newKey, weight);
            }
        }
        Iterator<String> iterator = weightMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            visitedMap.put(key, false);
        }
        System.out.println();
        helper1(sourceIdChar, desIdChar, weightMap, idList, new LinkedList());
    }

    public static List<List<String>> result = new ArrayList<>();


    public static void helper1(String source, String des, Map<String, Integer> weightMap, List<String> idList, LinkedList<String> tempList) {
        //查询能到D的节点
        if (source.equals(des)) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        Map<String, Integer> tempMap = new HashMap<>();
        for (int x = 0; x < idList.size(); x++) {
            if (weightMap.containsKey(idList.get(x) + "->" + des) && !visitedMap.get(idList.get(x) + "->" + des)) {
                visitedMap.put(idList.get(x) + "->" + des, true);
                tempMap.put(idList.get(x) + "->" + des, weightMap.get(idList.get(x) + "->" + des));
            }
        }
        if (tempMap.isEmpty()) {
            return;
        }


        List<String> list = new ArrayList<>();//["B->D","E->D"]
        Iterator<String> iterator = tempMap.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            list.add(next);
        }

        String[] newChar = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            newChar[x] = String.valueOf(list.get(x).toCharArray()[0]); //"B" "E" ，可以到D的节点
        }
        for (int x = 0; x < newChar.length; x++) {
            tempList.addFirst(newChar[x]);
            helper1(source, newChar[x], weightMap, idList, tempList);
            tempList.removeFirst();
        }
        return;
    }


    public static void main(String[] args) {
        //去构建城市之间的关系
        City A = new City("A", "A");
        City B = new City("B", "B");
        City C = new City("C", "C");
        City D = new City("D", "D");
        City E = new City("E", "E");
        //A
        List<City> aList = new ArrayList<>();
        aList.add(B);
        aList.add(C);
        CityFiber aCityFiber = new CityFiber(A, aList);
        //B
        List<City> bList = new ArrayList<>();
        bList.add(A);
        bList.add(C);
        bList.add(D);
        CityFiber bcityFiber = new CityFiber(B, bList);
        //C
        List<City> cList = new ArrayList<>();
        cList.add(A);
        cList.add(B);
        CityFiber ccityFiber = new CityFiber(C, cList);
        //D
        List<City> dList = new ArrayList<>();
        dList.add(B);
        dList.add(E);
        CityFiber dcityFiber = new CityFiber(D, dList);
        //E
        List<City> eList = new ArrayList<>();
        eList.add(D);
        CityFiber ecityFiber = new CityFiber(E, eList);
        List<CityFiber> list = new ArrayList<>();
        list.add(aCityFiber);
        list.add(bcityFiber);
        list.add(ccityFiber);
        list.add(dcityFiber);
        list.add(ecityFiber);
        System.out.println();
        List<String> nodeIdlist = new ArrayList<>();
        nodeIdlist.add("C");
        List<String> resolve = resolve(list, nodeIdlist);
        for (int x = 0; x < resolve.size(); x++) {
            System.out.print(resolve.get(x) + "、");
        }


    }
}
