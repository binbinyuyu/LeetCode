package 算法导论复习;

import java.util.HashSet;
import java.util.Set;

// N皇后问题
// https://leetcode-cn.com/problems/n-queens-ii/solution/nhuang-hou-ii-by-leetcode-solution/
public class Problem_12 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(totalNQueens(i));
        }
    }

    /**
     * N皇后，回溯算法
     *
     * @param n
     * @return
     */
    public static int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();//每一列
        Set<Integer> diagonals1 = new HashSet<>();//左上到右下的斜线，行-列的差相等则在一条斜线上
        Set<Integer> diagonals2 = new HashSet<>();//右上到左下的斜线，行+列的和相等则在一条斜线上
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    /**
     * 回溯
     * 每次向新的一行放皇后
     *
     * @param n
     * @param row        该轮中，皇后需要放置的行
     * @param columns
     * @param diagonals1
     * @param diagonals2
     * @return
     */
    public static int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        int count = 0;
        if (row == n) {//皇后都放完了，解法数量+1
            count = 1;
        } else {
            //依次尝试每一列是否可行
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int s1 = row - i;
                if (diagonals1.contains(s1)) {
                    continue;
                }
                int s2 = row + i;
                if (diagonals2.contains(s2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(s1);
                diagonals2.add(s2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(s1);
                diagonals2.remove(s2);
            }
        }
        return count;
    }
}
