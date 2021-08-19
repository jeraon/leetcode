package _2021_08._0816_0822;

/**
 * [题目]：剑指 Offer 10- II. 青蛙跳台阶问题
 * 
 * [描述]：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * [原题链接]：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 
 * [解决方案]：Fibonacci问题的变种，设台阶数为N， 跳法为F(N)， 则：
 *          N = 0时，有1种跳法；
 *          N = 1时，有1种跳法；
 *          N = 2时，有2种跳法；
 *          N = 3时，有3种跳法；
 *          N = n时，有F(N - 1) + F(N - 2)种跳法；
 */
public class FrogJumpStepsWay {

    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}
