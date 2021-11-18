package leetcode;

public class Solution1143 {
    public static void main(String[] args) {
        //System.out.println(longestCommonSubsequence("bdcaba", "abcbdab"));
        solveLongestCommonSubsequence("bdcaba", "abcbdab");
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    /**
     * 求最长公共子序列并输出一个序列
     *
     * @param text1
     * @param text2
     * @return
     */
    public static void solveLongestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }
        System.out.println("最长公共子序列的长度为：" + dp[m][n]);

        String result = "";
        for (int i = m, j = n; i != 0 && j != 0; ) {
            if (dp[i][j] == dp[i][j - 1]) //左侧
                j--;
            else if (dp[i][j] == dp[i - 1][j]) //上侧
                i--;
            else {//左上
                result = text1.charAt(i - 1) + result;
                i--;
                j--;
            }
        }
        System.out.println("一个最长公共子序列为：" + result);
    }
}
