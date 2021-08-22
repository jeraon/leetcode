package _2021_08._0816_0822;

/**
 * [题目]：剑指 Offer 12. 矩阵中的路径
 * 
 * [描述]： 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回
 * false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * [原题链接]：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 
 * [解决方案]：深度优先遍历 + 剪枝. 矩阵查找，一般采用深度优先算法，对每个元素的四个方向分别开始寻找。
 * 
 * 时间复杂度： 时间复杂度：一个非常宽松的上界为O(MN⋅3^L)，其中 M, NM,N 为网格的长度与宽度，LL 为字符串word
 * 的长度。在每次调用函数 check 时，除了第一次可以进入 4个分支以外，其余时间我们最多会进入3
 * 个分支（因为每个位置只能使用一次，所以走过来的分支没法走回去）。由于单词长为 L，故dfs(i,j,0)
 * 的时间复杂度为 O(3^L)，而我们要执行O(MN)次检查。然而，由于剪枝的存在，我们在遇到不匹配或已访问的字符时会提前退出，终止递归流程。
 * 因此，实际的时间复杂度会远远小于Θ(MN⋅3^L)。
 * 空间复杂度： O(1) 没有额外空间占用
 */
public class PathInMatrix {
    
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == words[0]) {
                    if (dfs(board, words, m, n, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int row, int column, int index) {
        if (index == words.length) return true;
        if (row >= board.length || column >= board[0].length || row < 0 || column < 0) return false;
        if (board[row][column] != words[index]) return false;
        char temp = board[row][column];
        board[row][column] = '\0';
        boolean result = dfs(board, words, row + 1, column, index + 1)
                || dfs(board, words, row - 1, column, index + 1)
                || dfs(board, words, row, column + 1, index + 1)
                || dfs(board, words, row, column - 1, index + 1);
        board[row][column] = temp;
        return result;
    }
}
