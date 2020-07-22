package com.itheima.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author YXH
 * @date 2019/11/18 - 15:09
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintBinaryTreeFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode t = deque.pop();
            list.add(t.val);
            if(t.left != null) {
                deque.add(t.left);
            }
            if(t.right != null) {
                deque.add(t.right);
            }
        }
        return list;
    }
}
