package 算法导论复习;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//找到下一个更大元素
// https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
public class Problem_11 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 4, 3};
        System.out.println(findNextGreaterNum(nums, 3));
    }

    public static int findNextGreaterNum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (!deque.isEmpty() && num >= deque.peek()) {//找到它看到的最大值
                deque.pop();
            }
            map.put(num, deque.isEmpty() ? -1 : deque.peek());
            deque.push(num);
        }
        return map.get(target);
    }
}
