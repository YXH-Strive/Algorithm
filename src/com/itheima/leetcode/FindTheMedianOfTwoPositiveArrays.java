package com.itheima.leetcode;

/**
 * @author YXH
 * @date 2020/11/4 - 9:39
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class FindTheMedianOfTwoPositiveArrays {
    public static void main(String[] args) {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int res[] = new int[m + n];
        int i = 0;
        int m1 = 0;
        int n1 = 0;
        while (m > 0 && n > 0) {
            if (nums1[m1] > nums2[n1]) {
                res[i] = nums2[n1];
                n--;
                n1++;
                i++;
                continue;
            }
            if (nums1[m1] < nums2[n1]) {
                res[i] = nums1[m1];
                m--;
                m1++;
                i++;
                continue;
            }
            if (nums1[m1] == nums2[n1]) {
                res[i] = nums1[m1];
                m--;
                m1++;
                i++;
                res[i] = nums2[n1];
                n--;
                n1++;
                i++;
                continue;
            }
        }
        while (m > 0) {
            res[i] = nums1[m1];
            m--;
            m1++;
            i++;
        }
        while (n > 0) {
            res[i] = nums2[n1];
            n--;
            n1++;
            i++;
        }
        if (res.length % 2 == 1) {
            return ((double)res[res.length / 2]);
        } else {
            return ((double)res[res.length / 2] + (double)res[res.length / 2 - 1]) / 2;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
