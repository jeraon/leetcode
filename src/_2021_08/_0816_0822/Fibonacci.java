package _2021_08._0816_0822;

/**
 * [题目]：剑指 Offer 10- I. 斐波那契数列 [描述]：写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n
 * 项（即F(N)）。斐波那契数列的定义如下：
 *  F(0) = 0, 
 *  F(1) = 1 
 *  F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * [原题链接]：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/ 
 * 
 * [解决方案]：
 * fib数列的性质： 0, 1, 2, 3, 5, 8, 13, .... 第一种解法：递归， 递归出口： n = 1 或n = 0时：
 * 
 * public int fib(int n) { 
 *      if (n == 0) return 0; 
 *      if (n == 1) return 1; 
 *      return fib(n - 1) + fib(n - 2); 
 * }
 * 
 * 这种解法缺点是出现许多重复子问题； 
 * 
 * 第二种解法： 自底向上遍历；
 */
public class Fibonacci {

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = (b + a) % 1000000007;  // 取模
            a = b;
            b = c;
        }
        return c;
    }
}
