package com.itheima.swordRefersToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YXH
 * @date 2020/11/3 - 9:58
 * <p>
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * <p>
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * <p>
 * 返回值
 * [[8],[6,10],[5,7,9,11]]
 */
public class PrintABinaryTreeIntoMultipleLines {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(pRoot);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int num = q.size();
            for (int i = 0; i < num; i++) {
                TreeNode temp = q.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            res.add(new ArrayList(list));
        }
        return res;
    }

}