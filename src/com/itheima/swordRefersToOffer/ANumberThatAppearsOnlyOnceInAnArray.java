package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/7/25 - 17:19
 * <p>
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class ANumberThatAppearsOnlyOnceInAnArray {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length < 2) {
            return ;
        }
        /**
         * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
         * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，
         * 先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
         * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
         * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
         * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
         */
        int myxor = 0;
        int flag = 1;
        for(int i = 0 ; i < array.length; ++ i ) {
            myxor ^= array[i];
        }
        while((myxor & flag) == 0) {
            flag <<= 1;
        }
        for(int i = 0; i < array.length; ++ i ){
            if((flag & array[i]) == 0) {
                num2[0]^= array[i];
            } else {
                num1[0]^= array[i];
            }
        }
    }
}
