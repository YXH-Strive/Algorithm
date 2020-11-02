package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/11/2 - 18:24
 * <p>
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricBinaryTrees {
    public boolean jude(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        } else {
            return jude(node1.left, node2.right) && jude(node1.right, node2.left);
        }
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || jude(pRoot.left, pRoot.right);
    }
}
