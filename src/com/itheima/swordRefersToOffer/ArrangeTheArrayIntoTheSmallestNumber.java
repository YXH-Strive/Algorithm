package com.itheima.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author YXH
 * @date 2020/7/24 - 17:43
 * <p>
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ArrangeTheArrayIntoTheSmallestNumber {
    public String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list=new ArrayList<Integer>();
        n=numbers.length;

        for(int i=0;i<n;i++){
            list.add(numbers[i]);
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list,new Comparator<Integer>(){

            @Override
            public int compare(Integer str1, Integer str2) {
                // TODO Auto-generated method stub
                String s1=str1+""+str2;
                String s2=str2+""+str1;

                return s1.compareTo(s2);
            }
        });
        for(int j:list){
            s+=j;
        }
        return s;
    }
}
