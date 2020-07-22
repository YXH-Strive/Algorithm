package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/11/27 - 8:54
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BinarySearchTreeAndDoubleLinkedList {
    TreeNode first;
    TreeNode lastleft;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) {
            return pRootOfTree;
        }
        Convert(pRootOfTree.left);
        if(first==null) {
            first = pRootOfTree;
        }
        if(lastleft!=null) {
            lastleft.right = pRootOfTree;
        }
        pRootOfTree.left = lastleft;
        lastleft = pRootOfTree;
        Convert(pRootOfTree.right);
        return first;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}