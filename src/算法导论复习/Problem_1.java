package 算法导论复习;

//The 3 teachers predicted a student competition. Their predictions are as follows:
//A said: student A is the first, student B is the third.
//B said: Student C was the first and student D was the fourth.
//C said: Student D is the second, student A is the third.
//The results show that they are half right, and half wrong with no ranking .
//Try to program the input a, b, c, d their respective rankings .

//https://blog.csdn.net/weixin_51136573/article/details/109567180
public class Problem_1 {
    public static void main(String[] args) {
        solve();
    }

    /**
     * A:a=1,b=3
     * B:c=1,d=4
     * C:d=2,a=3
     */
    public static void solve() {
        for (int a = 1; a <= 4; a++) {
            for (int b = 1; b <= 4; b++) {
                for (int c = 1; c <= 4; c++) {
                    for (int d = 1; d <= 4; d++) {
                        if ((a != b && a != c && a != d && b != c && b != d && c != d) &&
                                (a == 1) ^ (b == 3) && (c == 1) ^ (d == 4) && (d == 2) ^ (a == 3))
                            System.out.printf("a:%d,b:%d,c:%d,d:%d\n", a, b, c, d);
                    }
                }
            }
        }
    }
}
