package 算法导论复习;

import java.util.Arrays;

//https://leetcode-cn.com/problems/merge-sorted-array/
public class Problem_3 {
    public static void main(String[] args) {

    }

    /**
     * 直接合并两个数组，然后排序
     */
    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * 使用双指针，每次将两个指针中小的那个放到结果中
     * 时间复杂度是O(m+n)，空间复杂度是O(m+n)
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int p1 = 0, p2 = 0;
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {//nums1遍历完了
                cur = nums2[p2++];
            } else if (p2 == n) {//nums2遍历完了
                cur = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums2[p2++];
            } else {
                cur = nums1[p1++];
            }
            sort[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sort[i];
        }
    }

    /**
     * 使用双指针，从两个数组的尾部开始，每次将两个指针中小的那个放到结果中
     * 改良方法2，优化空间复杂度
     * 时间复杂度是O(m+n)，空间复杂度是O(1)
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int p1 = m - 1, p2 = n - 1;
        int cur;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {//nums1遍历完了
                cur = nums2[p2--];
            } else if (p2 == -1) {//nums2遍历完了
                cur = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums2[p2--];
            } else {
                cur = nums1[p1--];
            }
            nums1[tail--] = cur;
        }
    }
}