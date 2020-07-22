package com.itheima.leetcode.ByteDance;

import java.util.LinkedList;

/**
 * @author YXH
 * @date 2020/7/17 - 11:31
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int num=0;//记录最长子串长度
        int current=0;//记录当前子串长度
        char[] arr=s.toCharArray();
        LinkedList<Character> temp=new LinkedList<>();

        for (int i=0;i<arr.length ;i++ )
        {
            if (!temp.contains(arr[i]))
            {
                temp.add(arr[i]);
                current=temp.size();
                if (current>num) {
                    num=current;
                }
            }
            else//如果新增字符与原子串中字符有重复的，删除原子串中重复字符及在它之前的字符，与新增字符组成新的子串
            {
                temp.add(arr[i]);
                int first=temp.indexOf(arr[i]);

                for (int j=0;j<first ;j++ ) {
                    temp.remove();
                }

                temp.remove();
            }
        }
        return num;
    }
}
