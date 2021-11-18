package leetcode;

import java.util.concurrent.TimeUnit;

public class Solution240 {
    public static void main(String[] args) {

    }

    /**
     * 遍历二维数组查询
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target)
                return false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > target)
                    break;
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    /**
     * 二分查找的思路
     * https://www.cnblogs.com/kyoner/p/11080078.html\
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix3(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index != -1)
                return true;
        }
        return false;
    }

    private static int search(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;//两端都是闭区间
        while (left <= right) {
            int mid = (right - left) / 2 + left;//防止right+left溢出
            if (row[mid] == target) {
                return mid;
            } else if (row[mid] > target) {
                right = mid - 1;
            } else if (row[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
