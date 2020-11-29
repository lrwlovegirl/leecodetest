
package com.lrw.algorithm.tree.middle;

import com.lrw.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树之字形遍历
 */
public class ZigZagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        getResult(root,0,ans);
        return ans;
    }

    private static void getResult(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (level == ans.size()) {
            List<Integer> resultLevel = new ArrayList<>();
            if (level % 2 == 0) {
                resultLevel.add(root.val);
            } else {
                resultLevel.add(0, root.val);
            }
            ans.add(resultLevel);
        } else {
            List<Integer> resultLevel = ans.get(level);
            if (level % 2 == 0) {
                resultLevel.add(root.val);
            } else {
                resultLevel.add(0, root.val);
            }
            ans.add(resultLevel);
        }
        getResult(root.left, level + 1, ans);
        getResult(root.right, level + 1, ans);
    }

}
