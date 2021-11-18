package leetcode;

import java.util.*;
import java.util.regex.Pattern;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                int newValue = hashMap.get(num) + 1;
                hashMap.put(num, newValue);
            }
        }

        List<Integer> result = new ArrayList<>();
        int bound = (int) Math.floor(nums.length / 3.0);
        hashMap.forEach((k, v) -> {
            if (v > bound) result.add(k);
        });
        return result;
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement2(int[] nums) {
        int participant1 = 0;
        int participant2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            if (participant1 == num && vote1 != 0) {//第一个数加一
                vote1++;
            } else if (participant2 == num && vote2 != 0) {//第二个数加一
                vote2++;
            } else if (vote1 == 0) {//投给第一个数
                participant1 = num;
                vote1 = 1;
            } else if (vote2 == 0) {//投给第二个数
                participant2 = num;
                vote2 = 1;
            } else {//三个数不相等，都减一
                vote1--;
                vote2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == participant1) count1++;
            if (num == participant2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(participant1);
        if (count2 > nums.length / 3 && participant1 != participant2) result.add(participant2);
        return result;
    }

    public static void main(String[] args) {
        majorityElement2(new int[]{1,2,3,4,5,6,7,8,9});
    }
}
