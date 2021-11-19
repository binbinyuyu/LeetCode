package 算法导论复习;

//动态规划
// https://leetcode-cn.com/problems/maximum-subarray/
public class Problem_13 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];//表示以第i个字符结尾的最大子序和
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }
        }
        int max = dp[0];
        for (int num : dp) {
            if (max < num)
                max = num;
        }
        return max;
    }


    /**
     * 官方题解，空间复杂度降到O(1)
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int preMaxSum = 0;
        int max = nums[0];
        for (int num : nums) {
            preMaxSum = Math.max(preMaxSum+num,num);
            max = Math.max(preMaxSum,max);
        }
        return max;
    }
}
