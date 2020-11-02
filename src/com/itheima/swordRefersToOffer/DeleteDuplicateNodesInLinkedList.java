package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/9/18 - 17:00
 * <p>
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicateNodesInLinkedList {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //自己构建辅助头结点
        ListNode head = new ListNode(Integer.MAX_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                //相同结点一直往前走
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                //退出循环时，cur指向重复值，也需要删除，而cur.next指向第一个不重复的值
                // cur继续前进
                cur = cur.next;
                //pre连接新结点
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

}
