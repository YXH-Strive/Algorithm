package com.itheima.swordRefersToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author YXH
 * @date 2020/11/3 - 10:39
 * <p>
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后
 * 位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class MedianInDataStream {
    ArrayList<Integer> list =new ArrayList<Integer>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        int len = list.size();
        if(list == null) {
            return null;
        }
        else if(list.size()%2 == 0) {
            return (list.get(len/2)+list.get(len/2-1))/2.0;
        }
        else {
            return Double.valueOf(list.get(len/2));
        }
    }
}
