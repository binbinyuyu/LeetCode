package 算法导论复习;

import java.util.HashMap;
import java.util.Map;

public class Problem_6 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 9, 13, 15};
        findSum(nums, 12);
    }

    public static int[] findSum(int[] nums, int target) {
        int i = -1, j = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i]))
                map.put(nums[i], i);
            else {
                j = map.get(target - nums[i]);
                break;
            }
        }
        System.out.printf("两个下标分别是:%d,%d",i,j);
        return new int[]{i, j};
    }
}
