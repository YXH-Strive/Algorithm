package com.itheima.leetcode.ByteDance;

/**
 * @author YXH
 * @date 2020/7/18 - 11:40
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {               //该字符数组为空，直接返回“”
            return result;
        }
        int i = 0;
        while (i < strs[0].length())      //用第一个字串的长度来操作，因为无论他是否为最长还是最短的串，都不影响结果
        {
            char temp = strs[0].charAt(i); //将第一个字串的第i个字符赋给temp
            for (int j = 1; j < strs.length; j++)     //通过j++来进行与剩下的字串的第i个字符进行比较
            {
                if (i < strs[j].length() && strs[j].charAt(i) == temp) {   //如果第j个字串的第i个字符与temp相等，则判断下一个字串（j+1）的第i 个字符
                    continue;
                } else {              //如果不相等，则返回“”
                    return result;
                }
            }
            result += temp;                //将每次相等的字符加起来
            i++;
        }
        return result;                    //返回输出结果
    }
}
