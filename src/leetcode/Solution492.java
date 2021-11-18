package leetcode;

import java.sql.Time;

public class Solution492 {
    public static int[] constructRectangle(int area) {
        int a = (int) Math.sqrt(area);
        int column = 0;
        for (int row = a; row <= area; row++) {
            column = area / row;
            if (column * row == area) return new int[]{row, column};
        }
        return new int[0];
    }

    /**
     * 官方题解，耗时0ms
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle2(int area) {
        int w = (int) Math.sqrt(area);//w小于等于area的平方根
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }

    /**
     * 修改了官方题解，耗时37ms
     * 求余运算中，除数更大会运算更慢
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle3(int area) {
        int w = (int) Math.ceil(Math.sqrt(area));//w大于等于area的平方根
        while (area % w != 0) {
            w++;
        }
        return new int[]{w, area / w};
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();//程序运行开始时间
        for (int i = 0; i < 100; i++) {
            constructRectangle2(999999999);
        }
        long endTime = System.currentTimeMillis();//获取当前的系统时间，与初始时间相减就是程序运行的毫秒数
        long usedTime = (endTime - startTime);//除以1000就是秒数
        System.out.println(usedTime);


        startTime = System.currentTimeMillis();//程序运行开始时间
        for (int i = 0; i < 100; i++) {
            constructRectangle3(999999999);
        }
        endTime = System.currentTimeMillis();//获取当前的系统时间，与初始时间相减就是程序运行的毫秒数
        usedTime = (endTime - startTime);//除以1000就是秒数
        System.out.println(usedTime);
    }
}
