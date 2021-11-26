package 算法导论复习;

//将一个分数拆分为多个形式为1/q的分数之和
//见第六组ppt
public class Problem_26 {
    public static void main(String[] args) {
        solve(7, 8);
    }

    /**
     * @param numerator   分子
     * @param denominator 分母
     */
    public static void solve(int numerator, int denominator) {
        System.out.printf("%d/%d=", numerator, denominator);
        while (true) {
            if (denominator % numerator == 0) {
                denominator = denominator / numerator;
                numerator = 1;
            }
            if (numerator == 1) {
                System.out.printf("+%d/%d", 1, denominator);
                break;
            } else {
                int n = numerator;
                int d = denominator;
                int num = denominator / numerator + 1;
                System.out.printf("+%d/%d", 1, num);
                numerator = n * num - d;
                denominator = d * num;
            }
        }
    }
}
