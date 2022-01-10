package com.springboottemplate.leetcode.linked;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 206. 反转链表
 * @date 2021/12/16 15:06
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    @Test
    public void 测试() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = reverseList(head);
    }

    /***
     * 1--> 2--> 3--> 4--> 5
     *
     * 1 <--2 <--3<-- 4 <--5
     * 定两个指针，left 与right,每次把right的next指向left即可，局部改变，影响到全局改变
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode lift = null; //左指针。
        ListNode right = head;//右指针，右指针的默认位置是1开始
        while (right != null) {
            ListNode next = right.next;//右指针下一个元素。
            right.next = lift;
            lift = right;
            right = next;
        }
        return lift;
    }


    /**
     * 官方的，不好理解
     *
     * @param head
     * @return
     */
    public ListNode reverseListA(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}

/**
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
