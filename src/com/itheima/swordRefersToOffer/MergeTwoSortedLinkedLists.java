package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2019/11/18 - 14:51
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoSortedLinkedLists {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newList = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p3 = newList;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }

        while (p1 != null) {
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }

        while (p2 != null) {
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return newList.next;
    }
}
