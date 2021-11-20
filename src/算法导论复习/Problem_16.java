package 算法导论复习;

//链接中的方法二
//https://blog.csdn.net/weibo_dm/article/details/80531465?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link
public class Problem_16 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(solve(i));
        }
    }


    public static int solve(int a) {
        int i = 1;
        int count = 0;
        while (i != 0) {//int为32位，左移32次后终止循环
            if ((a & i) != 0) {
                count++;
            }
            i <<= 1;//i左移一位
        }
        return count;
    }
}
