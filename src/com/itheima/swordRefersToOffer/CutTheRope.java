package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/11/3 - 14:26
 * <p>
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * <p>
 * 返回值描述:
 * 输出答案。
 * <p>
 * 示例1
 * 输入
 * 8
 * <p>
 * 返回值
 * 18
 */
public class CutTheRope {
    public int cutRope(int target) {
        int a = 0;
        int c = 0;
        int maxValue = 2;

        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        if (target % 3 == 0) {
            maxValue = (int) Math.pow(3, target / 3);
        } else {
            a = target - 2;
            c = a % 3;

            maxValue = maxValue * (int) Math.pow(3, a / 3);
            if (0 != c) {
                maxValue = maxValue * c;
            }
        }

        return maxValue;
    }
}
