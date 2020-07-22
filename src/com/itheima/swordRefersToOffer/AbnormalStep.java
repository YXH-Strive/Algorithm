package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/11/18 - 14:40
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class AbnormalStep {
    /**
     * 分析
     * 设n级台阶有f(n)种跳法，根据最后一次跳台阶的数目可以分解为最后一次一级，
     * 则前面需要跳n-1级，有f(n-1)种跳法；最后一次跳两级，则前面需要跳n-2级，有f(n-2)种跳法。
     * 以此类推 易知，f(n)=f(n-1)+f(n-2)+...+f(1)
     *               f(n-1)=f(n-2)+...f(1)
     *               得:f(n)=2*f(n-1)
     */
    public int JumpFloorII(int target) {
        if(target <= 2) {
            return target;
        } else {
            return JumpFloorII(target - 1) * 2;
        }
    }
}
