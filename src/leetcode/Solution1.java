package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        return new int[]{0, 1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            //数组中的值作为key，数组下标作为value
            if (!hash.containsKey(target - nums[i])) {
                hash.put(nums[i], i);
            } else {
                j = hash.get(target - nums[i]);
                break;
            }
        }
        return new int[]{j, i};
    }

    public static void main(String[] args) {

    }
}
