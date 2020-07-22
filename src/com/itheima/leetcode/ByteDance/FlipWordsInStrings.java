package com.itheima.leetcode.ByteDance;

/**
 * @author YXH
 * @date 2020/7/21 - 11:21
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class FlipWordsInStrings {

    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        //trim()去除字符串两头空格
        if(s == null || "".equals(s.trim())){
            return "";
        }else{
            //正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
            String [] strs = s.trim().split("\\s+");
            int len = strs.length-1;
            for(int i=len;i>=0;i--){
                if(i == 0){
                    sb.append(strs[i]);
                }else{
                    sb.append(strs[i]+" ");
                }
            }
            return sb.toString();
        }
    }
}
