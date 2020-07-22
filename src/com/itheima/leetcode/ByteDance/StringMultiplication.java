package com.itheima.leetcode.ByteDance;

/**
 * @author YXH
 * @date 2020/7/21 - 17:28
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class StringMultiplication {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1,num2));
    }
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i > -1; i--) {
            for (int j = num2.length() - 1; j > -1; j--) {
                //charAt的作用是返回字符串指定位置的char值。这个是字符，不是数字。
                //字符’0’的ascii码是48,数字0的值是0,-48是为了转换为数字。
                int a = (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
                if (a > 9) {
                    arr[i + j + 1] += a % 10;
                    arr[i + j] += a / 10;
                } else {
                    arr[i + j + 1] += a;
                }
                if (arr[i + j + 1] > 9) {
                    arr[i + j] += arr[i + j + 1] / 10;
                    arr[i + j + 1] = arr[i + j + 1] % 10;
                }

            }
        }
        StringBuilder sb = new StringBuilder("");
        int k = 0;
        //去除前导0
        while (arr[k] == 0 && k < num1.length() + num2.length()) {
            k++;
        }
        for (; k < num1.length() + num2.length(); k++) {
            sb.append(arr[k]);
        }
        return sb.toString();
    }

}
