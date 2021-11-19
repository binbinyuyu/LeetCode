package 算法导论复习;

//类似斐波那契数列
//https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/fei-bo-na-qi-shu-lie-by-leetcode-solutio-hbss/
public class Problem_9 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(solve(i));
        }
    }

    public static int solve(int n) {
        if (n <= 2) {
            return n;
        }
        int p = 1, q = 2, r = 0;
        for (int i = 2; i < n; i++) {
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }

}
