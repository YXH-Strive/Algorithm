package com.itheima.swordRefersToOffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author YXH
 * @date 2020/9/14 - 18:17
 * <p>
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class TheFirstCharacterInTheCharacterStreamThatDoesNotRepeat {
    Map<Character, Integer> map = new LinkedHashMap();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if(map.containsKey(ch)){
            map.put(ch,-1);
        }else{
            map.put(ch,1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for(char ch: map.keySet()){
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return '#';
    }
}
