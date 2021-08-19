package _2021_08._0816_0822;

/**
 * [题目]：剑指 Offer 11. 旋转数组的最小数字
 * 
 * [描述]：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 *        输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 
 * [原题链接]：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 
 * [解决方案]：二分法。对于递增数组旋转后，必然存在一个递增区间，因此我们将中间元素和右边元素进行比较，当：
 *          nums[mid] > nums[right]时，说明左半边递增，因此最小值在右边，left = mid + 1;
 *          nums[mid] < nums[right]时，说明右半边递增，因此最小值在左边，right = mid;
 *          nums[mid] = nums[right]时，说明存在相同元素，此时right--即可。
 *          最终，nums[right]即为最小元素
 * 
 * 平均时间复杂度：O(logN)
 * 空间复杂度：O(1)
 */
public class MinNumInRotatedArray {
    
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        int left = 0; 
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {  // 右边递增，最小值在左边
                right = mid;
            } else if (numbers[mid] > numbers[right]) {  // 左边递增， 最小值在右边
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[right];
    }
}
