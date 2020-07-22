package com.itheima.leetcode.ByteDance;

/**
 * @author YXH
 * @date 2020/7/22 - 16:01
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，
 * 则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbersTogether {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int num=0;//进位
        int sum=0;//和
        //先初始化一个节点值为0的空节点
        ListNode list = new ListNode(0);
        //此时cur与first都指向0节点
        ListNode cur= list;
        while(l1!=null||l2!=null) {
            //将l1和l2中的值赋给x，y；不能省略判断语句，不然执行深度不同的链表会直接报错
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            //求和
            sum=num+x+y;
            //num只可能为1或0
            num=sum/10;
            //为0节点之后的节点1赋值
            cur.next=new ListNode(sum%10);
            //现在cur指向节点1,l1与l2也切换到下一节点
            cur=cur.next;
            //不能省略判断语句，不然执行深度不同的链表会直接报错
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //由于数值相加有进位的话要放到下一个节点，所以增加一个判断语句
        if(num>0) {
            cur.next=new ListNode(num);
        }
        //加上返回值
        return list.next;
    }
}
