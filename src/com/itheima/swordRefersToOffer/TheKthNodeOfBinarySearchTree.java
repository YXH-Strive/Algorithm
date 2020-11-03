package com.itheima.swordRefersToOffer;

import java.util.Stack;

/**
 * @author YXH
 * @date 2020/11/3 - 10:32
 * <p>
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * <p>
 * 示例1
 * 输入
 * {5,3,7,2,4,6,8},3
 * <p>
 * 返回值
 * {4}
 * <p>
 * 说明：按结点数值大小顺序第三小结点的值为4
 */
public class TheKthNodeOfBinarySearchTree {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>(); //建立栈
        TreeNode cur = pRoot;
        //while 部分为中序遍历
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur); //当前节点不为null，应该寻找左儿子
                cur = cur.left;
            }else{
                cur = stack.pop();//当前节点null则弹出栈内元素，相当于按顺序输出最小值。
                if(--k == 0){ //计数器功能
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}
