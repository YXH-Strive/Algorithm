package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/11/18 - 14:41
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectangleCovering {
    public int RectCover(int target) {
        if (target <= 2){
            return target;
        }
        int pre1 = 2; // n 最后使用一块，剩下 n-1 块的写法
        int pre2 = 1; // n 最后使用两块，剩下 n-2 块的写法
        for (int i = 3; i <= target; i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1; //相对于 n+1 块来说，第 n 种的方法
    }
}
