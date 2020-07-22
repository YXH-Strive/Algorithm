package com.itheima.leetcode.ByteDance;

/**
 * @author YXH
 * @date 2020/7/19 - 15:58
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // 1. 对于空链表, 不需要任何处理
        if (head == null) {
            return null;
        }
        // 2. 对于只有一个元素的链表, 也不需要处理
        if (head.next == null) {
            return head;
        }
        // 3. 如果有多个节点
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            // 翻转指针的指向
            cur.next = prev;
            // 更新 prev 和 cur
            prev = cur;
            cur = next;
        }
        return newHead;
    }
}
