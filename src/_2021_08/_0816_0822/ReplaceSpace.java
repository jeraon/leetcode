package _2021_08._0816_0822;

/**
 * [题目]：剑指 Offer 05. 替换空格
 * 
 * [描述]：请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 
 * [原题链接]：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 
 * [解决方案]：字符数组替换。
 *          建立一个新字符数组，长度为原数组的3倍，然后对原数组进行遍历，遇到空格直接i进行替换，最后通过新字符数组创建一个String返回即可。
 * 时间复杂度：O(n) 对原数组进行了遍历；
 * 空间复杂度：O(n) 创建了一个临时数组，长度为原数组的3倍；
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        char[] dest = new char[s.length() * 3];
        char[] source = s.toCharArray();
        int j = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                dest[j++] = '%';
                dest[j++] = '2';
                dest[j++] = '0';
            } else {
                dest[j++] = source[i];
            }
        }
        return new String(dest, 0, j);
    }
}
