package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/9/14 - 13:41
 * <p>
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：
 * 规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class BuildingAProductArray {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int ret = 1;
        for (int i = 0; i < A.length; ret *= A[i++]) {
            B[i] = ret;
        }
        int res = 1;
        for (int j = A.length - 1; j >= 0; res *= A[j--]) {
            B[j] *= res;
        }
        return B;
    }
}
