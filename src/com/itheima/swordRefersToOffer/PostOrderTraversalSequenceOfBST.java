package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/11/20 - 8:54
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,
 * 否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class PostOrderTraversalSequenceOfBST {
   public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] seq, int start, int end) {
        if (start >= end) {
            return true;
        }
        int val = seq[end];
        int split = start;
        for (; split < end && seq[split] < val; split++) ;
        for (int i = split; i < end; i++) {
            if (seq[i] < val) {
                return false;
            }
        }
        return isBST(seq, start, split - 1) &&
                isBST(seq, split, end - 1);
    }
}
