package com.itheima.swordRefersToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YXH
 * @date 2020/11/2 - 18:51
 * <p>
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreesInZigzagOrder {
    //解题思路：其实就是二叉树的层级遍历，不过是在遍历的时候，需要将偶数层的节点逆序。
    //关键点：每次只处理上次在queue中剩余的节点，这是上一层的所有节点。
    //处理完后刚好将下一层的所有节点（包含null）又全部放了进去。
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (!reverse) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);//每次加到0的位置，就自动逆序了
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (list.size() > 0) {
                result.add(list);
            }
            reverse = !reverse;
        }
        return result;
    }
}
