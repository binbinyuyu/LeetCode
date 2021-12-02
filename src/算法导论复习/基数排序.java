package 算法导论复习;

import java.util.Arrays;

//https://www.cnblogs.com/skywang12345/p/3603669.html#a43
public class 基数排序 {
    public static void main(String[] args) {
        int[] a = new int[]{53, 3, 542, 748, 14, 214, 154, 63, 616};
        System.out.println(Arrays.toString(a));
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void radixSort(int[] a) {
        int max = getMax(a);
        for (int exp = 1; exp <= max; exp *= 10) {
            sorting(a, exp);
        }
    }

    /**
     * @param a
     * @param exp 1:个位,10:百位...
     */
    public static void sorting(int[] a, int exp) {
        int[] bucket = new int[10];
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {//计算每位数有多少个
            int pos = (a[i] / exp) % 10;
            bucket[pos]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = bucket[i] + bucket[i - 1];
        }
        for (int i = a.length - 1; i >= 0; i--) {//根据个数放到对应位置
            int pos = bucket[(a[i] / exp) % 10] - 1;
            bucket[(a[i] / exp) % 10]--;
            temp[pos] = a[i];
        }
        for (int i = 0; i < temp.length; i++) {//temp数组赋值回a
            a[i] = temp[i];
        }
    }

    public static int getMax(int[] a) {
        int max = a[0];
        for (int value : a) {
            if (max < value)
                max = value;
        }
        return max;
    }
}
