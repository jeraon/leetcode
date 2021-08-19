package _2021_08._0816_0822;


/**
 * [题目]：剑指 Offer 03. 数组中重复的数字
 * 
 * [描述]：找出数组中重复的数字。在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1
 *        的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 
 * [原题链接]：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 
 * [解决方案]： 
 * 方法一： 通过遍历数组中元素，并存在在一个容器中，此方案时间复杂度O(n)，空间复杂度O(n),每次会进行contains()判断，实际结果List会超出时间限制，改用HashSet.
 * 方法二： 原地哈希法： 由于n个数组的数字都在0~n-1内，因此在索引为i的位置上放置元素i。
 *          当i == nums[i]时，不需要调整；
 *          当nums[i] == nums[nums[i]]时，说明找到重复元素；
 *          当nums[i] ！= nums[nums[i]]时，将nums[i]放置到nums[nums[i]]上，直到i == nums[i]时，i++进行下一次循环。
 * 时间复杂度：O(n); 
 * 空间复杂度：O(1);
 */

public class FindRepeatNumberInArray {
    public int findRepeatNumber(int[] nums) {
        int i = 0; 
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) return nums[i];
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}
