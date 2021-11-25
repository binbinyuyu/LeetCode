package 算法导论复习;

import java.util.*;

//数列极差问题
//https://blog.csdn.net/u014788620/article/details/80957983
public class Problem_24 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < 4; i++)
            a.add(i);
        System.out.println(solveMax(a) - solveMin(a));
    }

    /**
     * 每次选最小的两个,乘出来最大
     *
     * @param temp
     * @return
     */
    public static int solveMax(List<Integer> temp) {
        List<Integer> a = new ArrayList<>(temp);
        Collections.sort(a);
        int x, y;
        while (a.size() > 1) {
            Collections.sort(a);
            x = a.get(0);
            y = a.get(1);
            a.add(x * y + 1);
            a.remove(a.indexOf(x));
            a.remove(a.indexOf(y));
        }
        return a.get(0);
    }

    /**
     * 每次选最大的两个,乘出来最小
     *
     * @param temp
     * @return
     */
    public static int solveMin(List<Integer> temp) {
        List<Integer> a = new ArrayList<>(temp);
        Collections.sort(a, (o1, o2) -> o2 - o1);
        int x, y;
        while (a.size() > 1) {
            Collections.sort(a, (o1, o2) -> o2 - o1);
            x = a.get(0);
            y = a.get(1);
            a.add(x * y + 1);
            a.remove(a.indexOf(x));
            a.remove(a.indexOf(y));
        }
        return a.get(0);
    }
}
