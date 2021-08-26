package _2021_08._0823_0829;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [题目]：剑指 Offer 13. 机器人的运动范围
 * 
 * [描述]：
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0]
 * 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，
 * 机器人能够进入方格[35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 
 * [原题链接]：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 
 * [解决方案]：方法一：广度优先遍历
 */
public class RobotMoveRange {

    public int movingCount(int m, int n, int k) {
        // 特殊判断
        if (k == 0) return 1;
        Deque<int[]> deque = new LinkedList<>();
        int count = 1;
        // x、y轴方向值，放在数组中便于计算
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        // 标记是否为访问过的元素
        boolean[][] visited = new boolean[m][n];
        deque.offer(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            for (int i = 0; i < 2; i++) {
                int x = cell[0] + dx[i];
                int y = cell[1] + dy[i];
                if (x >= m || y >= n || visited[x][y] || getSum(x) + getSum(y) > k) {
                    continue;
                }
                visited[x][y] = true;
                deque.offer(new int[]{x, y});
                count++;
            }
        }
        return count;
    }

    private int getSum(int i) {
        int ans = 0;
        while (i != 0) {
            ans += i % 10;
            i /= 10;
        }
        return ans;
    }
}
