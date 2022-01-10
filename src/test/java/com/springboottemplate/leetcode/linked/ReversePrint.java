package com.springboottemplate.leetcode.linked;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 唐涛
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * @date 2021/12/16 11:00
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {

    @Test
    public void 测试() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reversePrint(head);

    }

    /**
     * 方法1：获取链表的所有元素，然后放到集合、然后反转元素
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int arr[] = new int[list.size()];
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    /**
     * 方法2：获取链表的所有元素，然后放到栈中也行
     *
     * @param head
     * @return
     */
    public int[] reversePrintA(ListNode head) {

        return null;
    }

    /**
     * 方法3：比较难的方法，直接在原来的链表上进行反转元素，然后遍历反转后的链表放在集合中
     *
     * @param head
     * @return
     */
    public int[] reversePrintB(ListNode head) {
        //反转链表核心代码，
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return null;
    }


//
//    class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
}


