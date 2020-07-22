package com.itheima.leetcode.ByteDance;

import java.util.Arrays;

/**
 * @author YXH
 * @date 2020/7/22 - 12:18
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class TheKthLargestElementInTheArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 1;
        for (int i = nums.length-1; i >=0; i--) {
            if (j == k) {
                return nums[i];
            } else {
                j++;
            }
        }
        return -1;
    }
}