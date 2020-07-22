package com.itheima.swordRefersToOffer;

import java.util.ArrayList;

/**
 * @author YXH
 * @date 2019/11/18 - 14:31
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */
public class PrintLinkedListFromEndToEnd {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }
}
