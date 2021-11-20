package 算法导论复习;

import java.util.Arrays;
import java.util.Comparator;

// 贪心算法，先装最大的
//链接第五页
//https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/assignments/ps7.pdf
public class Problem_18 {
    public static void main(String[] args) {
        Integer[] G = new Integer[]{3, 3, 4, 5, 1, 6};
        System.out.println(solve(G, 16));
    }

    public static int solve(Integer[] G, int n) {
        Arrays.sort(G, (o1, o2) -> o2 - o1);//降序排序
        int admitted = 0;
        for (int num : G) {
            if (num < n) {//admit
                n -= num;
                admitted += num;
            } else {//reject
            }
        }
        return admitted;
    }
}
