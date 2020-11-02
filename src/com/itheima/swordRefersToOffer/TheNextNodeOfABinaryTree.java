package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/11/2 - 16:47
 * <p>
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class TheNextNodeOfABinaryTree {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 1.有右子树，下一结点是右子树中的最左结点
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
        // 2.无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        // 3.无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，
        // 直到找到某个结点是其父结点的左子树，如果存在这样的结点，
        // 那么这个结点的父结点就是我们要找的下一结点。
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}