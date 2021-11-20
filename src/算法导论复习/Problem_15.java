package 算法导论复习;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;

//活动安排问题，如何在一个地点举办最多的活动
//贪心算法，选择最早结束的活动
public class Problem_15 {
    public static void main(String[] args) {
        int[] s = new int[]{1, 3, 0, 5, 3, 5, 6, 8, 2, 10};//活动开始时间
        int[] f = new int[]{8, 6, 5, 9, 7, 14, 10, 11, 11, 12};//活动结束时间
        boolean[] isChosen = new boolean[s.length];//记录该活动是否被选择
        System.out.println(solve(s, f, isChosen));
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(f));
        System.out.println(Arrays.toString(isChosen));
    }

    /**
     * 按照结束时间从小到大排序
     * 然后每次选择结束最早的活动
     *
     * @param s
     * @param f
     * @param isChosen
     * @return
     */
    public static int solve(int[] s, int[] f, boolean[] isChosen) {
        quickSort(f, 0, f.length - 1, s);
        int count = 0;//总的活动数量
        int preEnd = 0;
        for (int i = 0; i < f.length; i++) {
            if (s[i] >= preEnd) {
                isChosen[i] = true;
                preEnd = f[i];
                count++;
            }
        }
        return count;
    }

    /**
     * 快速排序
     * https://blog.csdn.net/qq_40941722/article/details/94396010
     *
     * @param array 对结束时间进行排序
     * @param begin
     * @param end
     * @param s     排序时开始时间一起跟着动
     */
    public static void quickSort(int[] array, int begin, int end, int[] s) {
        if (begin > end)
            return;
        int temp = array[begin];
        int i = begin, j = end;
        while (i != j) {
            while (array[j] >= temp && j > i)
                j--;
            while (array[i] <= temp && j > i)
                i++;
            //交换i和j的位置
            int t = array[i];
            array[i] = array[j];
            array[j] = t;

            t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
        //将begin和i的位置交换
        array[begin] = array[i];
        array[i] = temp;
        temp = s[begin];
        s[begin] = s[i];
        s[i] = temp;
        quickSort(array, begin, i - 1, s);
        quickSort(array, i + 1, end, s);
    }
}
