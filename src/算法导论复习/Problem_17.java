package 算法导论复习;

import java.util.Scanner;

//连续邮资问题(其他组的代码)
//n种邮票，每张信封上最多贴m张邮票，求最大的邮资区间（从1开始，增量为1）
//https://blog.csdn.net/jcwkyl/article/details/4137398

class Problem_17 {
    static int m, n;
    static int Maxvalue;
    static int[] bestx = new int[10];

    public static void main(String[] args) {

        int i, j, max, cur;
        int[] x = new int[100];
        System.out.println("请输入发行邮票的种类：\\n");
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        System.out.println("请输入每张信封最多允许贴的邮票张数：\\n");
        Scanner scm = new Scanner(System.in);
        m = scm.nextInt();
        Maxvalue = 0;
        max = m;//max表示到目前为止的最大可到达邮资
        cur = 1;
        x[cur] = 1;
        Backtrack(x, cur, max);//x存储当前的解,cur表示当前传递到第几种邮票,max表示目前能表示到的最大值
        System.out.println("最佳设计方案：\n");
        for (i = 1; i <= n; i++)
            System.out.println(bestx[i]);
        System.out.println("最大邮资区间为");
        System.out.println(Maxvalue);
    }

    public static void Backtrack(int[] x, int cur, int max) {
        int i, j, next;
        if (cur == n)//如果已经得出了n种邮票
        {
            if (max > Maxvalue)//并且它的最大值已经大于当前最大邮资数
            {
                Maxvalue = max;
                for (i = 1; i <= cur; i++)
                    bestx[i] = x[i];//更新答案数组
            }
            return;
        }
        for (next = x[cur] + 1; next <= max + 1; next++)//如果还没得到n种邮票，那么从x[cur]+1~max+1选一个作为下一个邮资，因为max+1没法表示，所以必定到max+1为止
        {
            x[cur + 1] = next;//用种类为cur+1,数目分别为x[1..cur+1]的邮票,最多使用m张，能否表示出大于max的某个数
            for (i = max + 1; i <= m * x[cur + 1]; i++)//i为加入新邮票之后能达到的最大值，这个数最少要为max+1,最多是x[cur+1]*m
                if (judge(x, cur + 1, i) == 0)//等于0说明超过了m,此时的i不成立，如果成立则返回1，i++
                    break;
            if (i > max + 1)//如果至少让最大值更新了一次(最大值有所更新，继续加入下一个邮票)
                Backtrack(x, cur + 1, i - 1);//上层for循环得到i之后又判断了i+1,所以i-1
        }
    }

    public static int judge(int[] x, int t, int sum) {
        int i, j, k;
        int[][] y = new int[10][1000];
        for (i = 0; i <= t; i++)
            y[i][0] = 0;
        for (i = 0; i <= sum; i++)
            y[1][i] = i;
        for (i = 2; i <= t; i++)
            for (j = 1; j <= sum; j++) {
                y[i][j] = 10000;//把k=0时的y值获取到
                for (k = 0; k <= j / x[i]; k++)//要y取最小，所以应该尽可能的使用最大面值的x[i],最多能用j/x[i]张
                    if (y[i][j] > y[i - 1][j - x[i] * k] + k)//找最小的y
                        y[i][j] = y[i - 1][j - x[i] * k] + k;
            }
        if (y[t][sum] > m)
            return 0;
        return 1;
    }

}
