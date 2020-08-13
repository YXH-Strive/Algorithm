package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/7/25 - 16:19
 * <p>
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class BalancedBinaryTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1; //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;//如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        }
        if (left - right < (-1) || left - right > 1) {
            return -1;
        } else {
            return 1 + (left > right ? left : right);
        }
    }

}
