package 算法导论复习;

//找出1到n范围所有整数中1的出现次数
//https://blog.csdn.net/zxdspaopao/article/details/84672375
public class Problem_25 {
    public static void main(String[] args) {
        System.out.println(solve(12));
    }

    /**
     * 暴力
     *
     * @param n
     * @return
     */
    public static int solve(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int m = i;
            while (m != 0) {
                if (m % 10 == 1)
                    count++;
                m = m / 10;
            }
        }
        return count;
    }
}
