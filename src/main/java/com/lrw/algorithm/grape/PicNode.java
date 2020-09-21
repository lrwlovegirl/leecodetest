package com.lrw.algorithm.grape;
//图的节点
public class PicNode {
    int val;
    PicNode childrens [];
    boolean visited;

    public PicNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public PicNode[] getChildrens() {
        return childrens;
    }

    public void setChildrens(PicNode[] childrens) {
        this.childrens = childrens;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
