package 算法导论复习;

import java.util.*;

//会场安排问题，如何安排最少的会场让所有活动都能举行
//将活动按照开始时间从小到大排序
//https://www.cnblogs.com/gropeliang/p/13417802.html
public class Problem_21 {
    public static void main(String[] args) {
        int[] s = new int[]{1, 3, 0, 5, 3, 5, 6, 8, 2, 10};//活动开始时间
        int[] f = new int[]{8, 6, 5, 14, 7, 9, 10, 11, 11, 12};//活动结束时间
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            Activity temp = new Activity(s[i], 0);
            activities.add(temp);
        }
        for (int i = 0; i < f.length; i++) {
            Activity temp = new Activity(f[i], 1);
            activities.add(temp);
        }
        System.out.println(solve(activities));
    }

    public static int solve(List<Activity> activities) {
        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.time != o2.time ? o1.time - o2.time : o2.type - o1.type;
            }
        });
//        System.out.println(activities);

        int count = 0;
        int max = 0;
        for (Activity activity : activities) {
            if (activity.type == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }

    static class Activity {
        private int time;//活动开始时间或结束时间
        private int type;//0：开始时间，1：结束时间

        public Activity(int time, int type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public String toString() {
            return "{" +
                    "time=" + time +
                    ", type=" + type +
                    '}';
        }
    }
}
