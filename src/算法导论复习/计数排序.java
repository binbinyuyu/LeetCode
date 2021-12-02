package 算法导论复习;

import java.util.Arrays;

public class 计数排序 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        System.out.println(Arrays.toString(a));
        countingSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void countingSort(int[] a) {
        int max = getMax(a);
        int[] counting = new int[max + 1];
        for (int value : a) {
            counting[value]++;
        }
        int index = 0;
        for (int i = 1; i < counting.length; i++) {
            while (counting[i] != 0) {
                a[index] = i;
                index++;
                counting[i]--;
            }
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
