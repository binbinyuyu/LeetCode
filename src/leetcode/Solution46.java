package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution46 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution46 solution = new Solution46();
        List<List<Integer>> lists = solution.permute2(nums);
        System.out.println(lists);
    }

    /**
     * 使用状态数组标记每个数字是否被使用
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];//标记数字是否被使用过

        dfs1(nums, used, path, result);
        return result;
    }

    private static void dfs1(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//如果位置i的数字没用过
                used[i] = true;
                path.add(nums[i]);
                dfs1(nums, used, path, result);
                path.remove(path.size() - 1);//回溯，恢复状态
                used[i] = false;
            }
        }
    }

    private List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        for (int num : nums) {
            path.add(num);
        }
        boolean[] used = new boolean[nums.length];//标记数字是否被使用过

        dfs2(nums, result, path, 0);
        return result;
    }

    /**
     * 不使用状态数组
     *
     * @param nums
     * @param result
     * @param path
     * @param first  当前需要调换的数字位置
     */
    private static void dfs2(int[] nums, List<List<Integer>> result, List<Integer> path, int first) {
        if (first == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            Collections.swap(path, first, i);
            dfs2(nums, result, path, first + 1);
            Collections.swap(path, first, i);
        }
    }
}
