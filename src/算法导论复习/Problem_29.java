package 算法导论复习;

//猴子吃桃
//https://blog.csdn.net/sister_wang0712/article/details/83933610
public class Problem_29 {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int cur = 1;
        for (int i = 9; i > 0; i--) {
            cur = (cur + 1) * 2;
            System.out.printf("第%d天，共%d个桃子\n", i, cur);
        }
    }
}
