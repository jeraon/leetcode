package _2021_08._0823_0829;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * [题目]：从尾到头打印链表
 * 
 * [描述]：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 
 * [原题链接]：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 
 * [解决方案]： 
 * 方法一： 遍历两次，利用栈的结构特点实现; 
 *  时间复杂度：O(2N)，因为需要遍历两遍； 
 *  空间复杂度：O(N)，额外空间保存元素； 
 * 方法二： 递归到链表尾部，返回时将节点元素添加到列表中返回；
 *  时间复杂度：O(N)，递归整个链表； 
 *  空间复杂度：O(N)，额外空间保存元素；
 */
public class ReverseList {    
    /*  
    // 方法一： 遍历两次，利用栈的结构特点实现：
    public int[] reversePrint(ListNode head) {
        ListNode curNode = head;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (curNode != null) {
            stack.push(curNode.val);
            curNode = curNode.next;
        }
        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }
        return arr;
    } */

    // 方法二： 递归输出
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        reverse(head);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    private void reverse(ListNode node) {
        if (node == null) return;  // 递归出口
        reverse(node.next);
        list.add(node.val);
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
