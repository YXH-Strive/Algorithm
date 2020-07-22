package com.itheima.leetcode.ByteDance;

import java.util.Arrays;

/**
 * @author YXH
 * @date 2020/7/18 - 11:54
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class ArrangementOfStrings {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] h1 = new int[256];
        int[] h2 = new int[256];
        for (int i = 0; i < len1; i++) {
            //统计s1和s2中前len1个字符串中各个字符出现的次数，如果二者字符出现次数的情况完全相同，
            //说明s1和s2中前len1的字符互为全排列关系，直接返回true。
            h1[s1.charAt(i)]++;
            h2[s2.charAt(i)]++;
        }
        if (Arrays.equals(h1, h2)) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            //遍历s2之后的字符，对于遍历到的字符，对应的次数加1，由于窗口的大小限定为了len1，
            //所以每在窗口右侧加一个新字符的同时就要在窗口左侧去掉一个字符，每次都比较一下两个哈希表的情况
            h2[s2.charAt(i)]++;
            h2[s2.charAt(i - len1)]--;
            if (Arrays.equals(h1, h2)) {
                return true;
            }
        }
        return false;
    }
}
