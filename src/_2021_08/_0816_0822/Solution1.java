package _2021_08._0816_0822;

import java.util.Stack;

/**
 * [题目]：剑指 Offer 09. 用两个栈实现队列
 * [描述]：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * [链接]：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * [解决思路]：
 * 栈是先进后出，队列是先进先出。在保存数据时，通过两栈之间调整顺序，从而满足队列数据结构。
 */
public class Solution1 {
    static class CQueue {

        private Stack<Integer> mInStack;
        private Stack<Integer> mOutStack;
        public CQueue() {
            mInStack = new Stack<>();
            mOutStack = new Stack<>();
        }
        
        public void appendTail(int value) {
            mInStack.push(value);
        }
        
        public int deleteHead() {
            if (mOutStack.empty()) {
                while (!mInStack.empty()) {
                    mOutStack.push(mInStack.pop());
                }
            }
            if (!mOutStack.empty()) {
                return mOutStack.pop();
            }
            return -1;
        }
    }
}
