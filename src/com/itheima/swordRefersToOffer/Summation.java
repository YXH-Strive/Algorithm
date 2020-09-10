package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/9/10 - 16:59
 * <p>
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 */
public class Summation {
    public static int Sum_Solution(int n) {
        boolean ans = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}
