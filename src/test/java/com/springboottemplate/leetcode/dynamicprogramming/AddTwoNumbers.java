package com.springboottemplate.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: https://leetcode-cn.com/problems/add-two-numbers/
 * @date 2021/12/2 16:27
 * <p>
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {


    @Test
    public void addTwoNumbersTest() {
        ListNode l1_3 = new ListNode(3);
        ListNode l1_2 = new ListNode(4, l1_3);
        ListNode l1root = new ListNode(2, l1_2);


        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(6, l2_3);
        ListNode l2root = new ListNode(5, l2_2);


        ListNode listNode = addTwoNumbers(l1root, l2root);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;//用来统计是否进位的。如果某个节点进位了。下个节点的值要加1
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;//如果除10，是整数，说明需要进位。

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;

    }


    public ListNode mySolving(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);

        while (l1.next != null || l2.next != null) {

            int val = l1.val;

        }
        return null;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}