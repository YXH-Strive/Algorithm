package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/11/18 - 14:29
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlankSpace {
    public String replaceSpace(StringBuffer str) {
        if(str==null) {
            return null;
        }
        String s = str.toString();
        char[] c =s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < c.length ; i++ ){
            if(c[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(c[i]);
            }
        }
        String result = sb.toString();
        return result;
    }
}
