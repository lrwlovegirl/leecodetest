package com.lrw.algorithm.grape.simple;

import com.lrw.algorithm.grape.PicNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * v1 O
 * |  v5  v6
 * v2 O--O--O
 * |  |
 * v3 O--O v4
 * 图的深度优先遍历,demo
 */
public class DFSAndBFS {

    public static List<PicNode> dfsTraverse(PicNode root) {
        //resultList
        List<PicNode> resultNode = new ArrayList<>();
        dfsHelper(root, resultNode);
        return resultNode;
    }

    public static Queue<PicNode> bfsTraverse(PicNode root) {

        return null;
    }

    public static void dfsHelper(PicNode node, List<PicNode> resultNode) {
        if (node == null || node.isVisited()) {
            return;
        }
        resultNode.add(node);
        node.setVisited(true);
        PicNode[] childrens = node.getChildrens();
        if (childrens != null) {
            for (int x = 0; x < childrens.length; x++) {
                dfsHelper(childrens[x], resultNode);
            }
        }
    }


    public static void main(String[] args) {
        PicNode v1 = new PicNode(1);
        PicNode v2 = new PicNode(2);
        PicNode v3 = new PicNode(3);
        PicNode v4 = new PicNode(4);
        PicNode v5 = new PicNode(5);
        PicNode v6 = new PicNode(6);

        PicNode[] v1Childrens = new PicNode[]{v2};
        PicNode[] v2Childrens = new PicNode[]{v1, v3, v5};
        PicNode[] v3Childrens = new PicNode[]{v2, v4};
        PicNode[] v4Childrens = new PicNode[]{v4, v5};
        PicNode[] v5Childrens = new PicNode[]{v2, v4, v6};
        PicNode[] v6Childrens = new PicNode[]{v5};
        v1.setChildrens(v1Childrens);
        v2.setChildrens(v2Childrens);
        v3.setChildrens(v3Childrens);
        v4.setChildrens(v4Childrens);
        v5.setChildrens(v5Childrens);
        v6.setChildrens(v6Childrens);
        List<PicNode> picNodes = dfsTraverse(v1);
        for (int x = 0; x < picNodes.size(); x++) {
            System.out.println(picNodes.get(x).getVal());
        }
    }

}
