package com.springboottemplate.leetcode;

import org.junit.Test;

/**
 * @author 唐涛
 * @description: 19. 删除链表的倒数第 N 个结点
 * @date 2021/12/10 16:10
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {


    @Test
    public void testMiddlerMode() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode = removeNthFromEnd(head, 3);
        System.out.println(listNode);

    }

    /**
     * //todo ，我还是不太懂，后面还需要学习的
     *
     * 一种容易想到的方法是，我们首先从头节点开始对链表进行一次遍历，得到链表的长度 L。随后我们再从头节点开始对链表进行一次遍历，当遍历到第 L-n+1个节点时，它就是我们需要删除的节点。
     *
     * 为了与题目中的 nn 保持一致，节点的编号从 11 开始，头节点为编号 11 的节点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;

    }


    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }


}
