package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/9/10 - 17:41
 * <p>
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * <p>
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 * <p>
 * 输出
 * 2147483647
 * 0
 */
public class StringToInteger {
    public int StrToInt(String str) {
        if (str == null || "".equals(str.trim())) {
            return 0;
        }
        str = str.trim();
        char[] arr = str.toCharArray();
        int i = 0;
        int flag = 1;
        int res = 0;
        if (arr[i] == '-') {
            flag = -1;
        }
        if (arr[i] == '+' || arr[i] == '-') {
            i++;
        }
        while (i < arr.length) {
            //是数字
            if (isNum(arr[i])) {
                int cur = arr[i] - '0';
                if (flag == 1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 7)) {
                    return 0;
                }
                if (flag == -1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 8)) {
                    return 0;
                }
                res = res * 10 + cur;
                i++;
            } else {
                //不是数字
                return 0;
            }
        }
        return res * flag;
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}

