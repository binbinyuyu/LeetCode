package 算法导论复习;

import java.util.Arrays;

public class 矩阵连乘 {
    public static void main(String[] args) {
        int[] p = new int[]{30, 35, 15, 5, 10, 20, 25};
        solve(p);
    }

    /**
     * 矩阵序号为1、2、3、4、5、6
     *
     * @param p
     */
    public static void solve(int[] p) {
        int size = p.length - 1;//矩阵个数
        int[][] w = new int[size + 1][size + 1];//w[i][j]:矩阵i乘到矩阵j所需要的代价
        int[][] s = new int[size + 1][size + 1];//s[i][j]:若值为k，则先乘i到k，再乘k+1到j
        for (int L = 2; L <= size; L++) {//矩阵链的长度从2开始
            for (int i = 1; i <= size - L + 1; i++) {//计算所有长度为L的矩阵链
                int j = i + L - 1;
                w[i][j] = -1;//赋初值为-1，避免值为0一直不能更新
                for (int k = i; k < j; k++) {
                    int newValue = w[i][k] + w[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (w[i][j] > newValue || w[i][j] == -1) {
                        w[i][j] = newValue;
                        s[i][j] = k;
                    }
                }
            }
        }

        for (int[] ints : w) {
            for (int i = 0; i < ints.length; i++) {
                System.out.printf("%5d\t", ints[i]);
            }
            System.out.println();
        }
        System.out.println();
        for (int[] ints : s) {
            for (int i = 0; i < ints.length; i++) {
                System.out.printf("%5d\t", ints[i]);
            }
            System.out.println();
        }
        print(s, 1, size);
    }

    public static void print(int[][] s, int i, int j) {
        if (i == j) {
            System.out.printf("A%d", i);
        } else {
            System.out.printf("(");
            print(s, i, s[i][j]);
            print(s, s[i][j] + 1, j);
            System.out.printf(")");

        }
    }
}
