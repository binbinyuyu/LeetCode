package 算法导论复习;

import java.util.Arrays;

//01背包问题
public class Problem_30 {
    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 5, 6, 7};
        int[] v = new int[]{1, 6, 18, 22, 28};
        solve(w, v, 11);
    }

    /**
     * @param w           重量
     * @param v           价值
     * @param totalWeight 背包总重量
     */
    public static void solve(int[] w, int[] v, int totalWeight) {
        //dp[i][j]:在前i个物品中挑选重量不超过j的物品，使价值最大化
        int[][] dp = new int[w.length + 1][totalWeight + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < totalWeight + 1; j++) {
                int weight = w[i - 1];
                int value = v[i - 1];
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight] + value, dp[i - 1][j]);
                }
            }
        }
        System.out.println("最大重量：" + dp[5][11]);

        int[] isChosen = new int[w.length];
        for (int i = w.length, j = totalWeight; i > 0 && j > 0; ) {
            if (dp[i][j] == dp[i - 1][j]) {//未装该物品
                i--;
            } else {//装了该物品
                isChosen[i - 1] = 1;
                j = j - w[i - 1];
                i--;
            }

        }
        System.out.println(Arrays.toString(isChosen));
    }
}
