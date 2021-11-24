package 算法导论复习;

//整数划分，将整数划分为可以相同的多个整数之和
//https://www.cnblogs.com/ACMERY/p/4947614.html
//链接中的1.1为该题解
public class Problem_22 {
    public static void main(String[] args) {
        System.out.println(dp(5));
    }

    public static int dp(int a) {
        int[][] dp = new int[a + 1][a + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else if (i > j) {
                    dp[i][j] = dp[i - j][j] + dp[i][j - 1];
                } else if (i == j) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else if (i < j) {
                    dp[i][j] = dp[i][i];
                }
            }
        }
        return dp[a][a];
    }
}
