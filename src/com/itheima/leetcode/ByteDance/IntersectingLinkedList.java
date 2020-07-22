package com.itheima.leetcode.ByteDance;

/**
 * @author YXH
 * @date 2020/7/22 - 17:21
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * <p>
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectingLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 获取两链表的长度，让长链表先步进长度差个单位，然后共同步进相同步距，
         * 两指针相等（即指向地址相同）时找到第一次也是最后一次相交的结点，返回该结点。
         * 找不到，返回空。
         */
        ListNode p1 = headA;
        ListNode p2 = headB;
        int len1 = 0;
        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        int len2 = 0;
        while(p2 != null){
            len2++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        int len = len1 - len2;
        if(len < 0){
            //单链表B是长的
            p1 = headB;
            p2 = headA;
            len = len2 - len1;
        }
        //最长的单链表永远是p1,并且差值len是一个正数
        for(int i = 0;i < len; i++){
            p1 = p1.next;
        }
        //p1和p2在同一个起跑线上
        while(p1 != null && p2 != null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == p2 && p1 != null && p2 != null ){
            return p1;
        }
        return null;

    }
}
