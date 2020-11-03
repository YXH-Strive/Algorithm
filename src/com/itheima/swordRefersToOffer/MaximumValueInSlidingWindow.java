package com.itheima.swordRefersToOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author YXH
 * @date 2020/11/3 - 10:46
 * <p>
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组
 * {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为
 * {4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 * <p>
 * 示例1
 * <p>
 * 输入
 * [2,3,4,2,6,2,5,1],3
 * <p>
 * 返回值
 * [4,4,6,6,6,5]
 */
public class MaximumValueInSlidingWindow {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0 || num == null || num.length == 0) {
            return list;
        }
        for (int i = 0; i <= num.length - size; i++) {
            for (int j = i; j < i + size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            list.add(max);
            max = Integer.MIN_VALUE;
        }
        return list;
    }
}
