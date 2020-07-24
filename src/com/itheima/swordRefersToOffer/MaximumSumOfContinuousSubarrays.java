package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/7/24 - 15:34
 * <p>
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class MaximumSumOfContinuousSubarrays {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int flag = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            flag = 0;
            for (int j = i; j < array.length; j++) {
                flag += array[j];
                if ( max < flag) {
                    max = flag;
                }
            }

        }
        return max;
    }

    /**{6,-3,-2,7,-15,1,2,2}
     * 典型的动态规划。dp[n]代表以当前元素为截止点的连续子序列的最大和，如果dp[n-1]>0，
     * dp[n]=dp[n]+dp[n-1]，因为当前数字加上一个正数一定会变大；如果dp[n-1]<0，dp[n]不变，
     * 因为当前数字加上一个负数一定会变小。使用一个变量max记录最大的dp值返回即可。
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1] > 0 ? array[i - 1] : 0;
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
