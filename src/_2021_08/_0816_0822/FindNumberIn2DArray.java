package _2021_08._0816_0822;

/**
 * [题目]：剑指 Offer 04. 二维数组中的查找
 * 
 * [描述]：在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *          请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * [原题链接]：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 
 * [解决方案]：由于该二维数组具有从上到下、从左至右递增的性质，因此从右上角开始查找。
 *           设行、列分别为m、n，则当target < matrix[0][n-1]时，说明小于右上角的值，此时列数-1, 否则行数+1. 
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int column = matrix[0].length;
        int m = 0;
        int n = column - 1;
        while (m < row && n >= 0) {
            if (target < matrix[m][n]) n--;
            else if (target > matrix[m][n]) m++;
            else return true;
        }
        return false;
    }
}
