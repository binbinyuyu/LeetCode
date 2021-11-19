package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution217 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.add(nums[i]))
                return true;
        }
        return false;
    }
}
