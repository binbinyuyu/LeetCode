package 算法导论复习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//全排列
//https://leetcode-cn.com/problems/permutations/
public class Problem_19 {
    public static void main(String[] args) {
        Character[] a = new Character[]{'a', 'b', 'c'};

        List<List<Character>> result = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        for (Character c : a) {
            path.add(c);
        }
        backtrack(result, path, 0, path.size());
        System.out.println(result);
    }

    /**
     * @param result 所有计算结果
     * @param path   排列的结果
     * @param start  该次回溯中，向该位置放数字
     * @param length 数字个数
     */
    public static void backtrack(List<List<Character>> result, List<Character> path, int start, int length) {
        if (start == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < length; i++) {
            Collections.swap(path, start, i);
            backtrack(result, path, start + 1, length);
            Collections.swap(path, start, i);
        }
    }
}
