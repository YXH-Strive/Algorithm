package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/7/24 - 11:52
 * <p>
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class TheNumberOfTimesANumberAppearsInASortedArray {
    public int GetNumberOfK(int [] array , int k) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k) {
                count++;
            }
        }
        return count;
    }
}
