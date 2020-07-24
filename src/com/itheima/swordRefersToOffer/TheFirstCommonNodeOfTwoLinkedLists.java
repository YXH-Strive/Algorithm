package com.itheima.swordRefersToOffer;

import java.util.List;

/**
 * @author YXH
 * @date 2020/7/24 - 11:22
 * <p>
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（
 * 注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class TheFirstCommonNodeOfTwoLinkedLists {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        /**
         * 获取两链表的长度，让长链表先步进长度差个单位，然后共同步进相同步距，
         * 两指针相等（即指向地址相同）时找到第一次也是最后一次相交的结点，返回该结点。
         * 找不到，返回空。
         */
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        int len2 = 0;
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        int len = len1 - len2;
        if (len < 0) {
            //单链表B是长的
            p1 = pHead2;
            p2 = pHead1;
            len = len2 - len1;
        }
        //最长的单链表永远是p1,并且差值len是一个正数
        for (int i = 0; i < len; i++) {
            p1 = p1.next;
        }
        //p1和p2在同一个起跑线上
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == p2 && p1 != null && p2 != null) {
            return p1;
        }
        return null;

    }
}
