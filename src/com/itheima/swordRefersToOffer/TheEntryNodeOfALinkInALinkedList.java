package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/9/18 - 15:21
 * <p>
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class TheEntryNodeOfALinkInALinkedList {
    /**
     * 初始化：快指针fast指向头结点， 慢指针slow指向头结点
     * 让fast一次走两步， slow一次走一步，第一次相遇在C处，停止
     * 然后让fast指向头结点，slow原地不动，让后fast，slow每次走一步，当再次相遇，就是入口结点。
     *
     * 头结点A    环入口结点B   相遇节点C   D在BC之间的某位置
     * AB距离X    BC距离Y
     *
     * 如果慢指针slow第一次走到了B点处，距离C点处还有距离Y，那么fast指针应该停留在D点处，
     * 且BD距离为Y（图中所示是假设快指针走了一圈就相遇，为了便于分析），
     * 也就是DB+BC=2Y，（因为fast一次走2步，慢指针一次走1步，并且相遇在C处）
     * 在C点处，此时慢指针slow走的点为ABC，距离为X+Y，而快指针fast走的点为ABCDBC，距离为2X+2Y，
     * 又因为：AB=X，BC=Y，快指针走了2次BC，所以CDB距离为X，而AB距离也为X。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (pHead != null && pHead.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
