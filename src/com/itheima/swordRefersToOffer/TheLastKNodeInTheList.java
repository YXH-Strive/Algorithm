package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/11/18 - 14:48
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class TheLastKNodeInTheList {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k<=0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        //p2向前移动k个节点
        for(int i=0;i<k-1;i++) {
            if(p2==null) {
                return null;
            }
            p2 = p2.next;
        }
        if(p2==null) {
            return null;
        }
        while(p2.next!=null) {
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}

