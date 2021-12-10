package com.springboottemplate.leetcode;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 876. 链表的中间结点
 * @date 2021/12/10 10:06
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * 方法一：首先遍历一遍单链表，记录链表的长度len，计算中间节点的位置。 用空间换时间：即开辟一个数据ListNode arr[]，记录所有节点，最后返回arr[len/2]的节点即可； 用时间换空间：再次遍历以便链表，遍历到len/2次时返回当前节点记为中间节点。
 * <p>
 * 方法二：利用快慢指针，快指针每次走两步，慢指针每次走一步，removeNthFromEnd所以快指针走的距离为慢指针的两倍，故当快指针遍历到链表末尾时，慢指针指向记为中间节点
 */
public class MiddleNode {

    @Test
    public void testMiddlerMode() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = middleNode(head);
        System.out.println(listNode);
        System.out.println(middleNodeA(head));
    }

    /**
     * 快慢指针:用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。
     * 12345
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;//这时候，slow的引用已经指向下一个ListNode了，不会影响head的值
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 首先遍历一遍单链表，记录链表的长度len，计算中间节点的位置,再次遍历以便链表，头结点一直指向下个节点，直到遍历到len/2次。
     *
     * @param head
     * @return
     */
    public ListNode middleNodeA(ListNode head) {
        int length = 1;
        ListNode currHead = head;
        while (currHead != null && currHead.next != null) {
            currHead = currHead.next;
            length += 1;
        }
        for (int i = 1; i <= length / 2; i++) {
            head = head.next;
        }
        return head;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}