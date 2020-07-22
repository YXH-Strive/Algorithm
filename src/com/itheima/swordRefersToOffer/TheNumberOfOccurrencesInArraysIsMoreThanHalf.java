package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/12/6 - 9:42
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class TheNumberOfOccurrencesInArraysIsMoreThanHalf {
   public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int preValue = array[0];//用来记录上一次的记录
        int count = 1;//preValue出现的次数（相减之后）
        for(int i = 1; i < array.length; i++){
            if(array[i] == preValue) {
                count++;
            } else{
                count--;
                if(count == 0){
                    preValue = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;//需要判断是否真的是大于1半数
       for (int anArray : array) {
           if (anArray == preValue) {
               num++;
           }
       }
        return (num > array.length/2)?preValue:0;
    }
}
