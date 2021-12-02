package 算法导论复习;

import java.util.Arrays;

public class 堆排序 {
    public static int[] a = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] a) {
        int len = a.length - 1;
        for (int i = a.length - 1; i >= 0; i--) {
            solveSort(i, len);
        }

        for (int i = a.length - 1; i != 0; i--) {
            swap(0, i);
            solveSort(0, i - 1);
        }
    }

    public static void solveSort(int parent, int len) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int maxPos = left;
        if (left > len)
            return;
        if (right <= len && a[left] < a[right]) {
            maxPos = right;
        }
        if (a[maxPos] > a[parent]) {
            swap(maxPos, parent);
            solveSort(maxPos, len);
        }
    }

    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
