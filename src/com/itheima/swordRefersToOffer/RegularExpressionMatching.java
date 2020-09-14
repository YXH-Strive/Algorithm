package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/9/14 - 15:06
 * <p>
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个
 * 模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionMatching {
    public boolean match(char[] str, char[] pattern) {
        /**
         * 动态规划转移方程：
         * f[i][j]表示s的前i个和p的前j个能否匹配
         * 对于方法一种的1,2两种情况可知：f[i][j] = f[i-1][j-1]
         * 对于第3种情况可知：
         * 如果重复0次，f[i][j] = f[i][j-2]
         * 如果重复1次或者多次，f[i][j] = f[i-1][j]
         * 动态规划初始条件：
         * s为空且p为空，为真: f[0][0] = 1
         * s不为空且p为空,为假: f[1..sn][0] = 0
         */
        int s = str.length;
        int p = pattern.length;
        boolean[][] f = new boolean[s + 1][p + 1];
        if (s == 0 && p == 0) {
            return true;
        }
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= p; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (pattern[j - 1] != '*') {
                        if (i > 0 && (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (str[i - 1] == pattern[j - 2] || pattern[j - 2] == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[s][p];
    }
}
