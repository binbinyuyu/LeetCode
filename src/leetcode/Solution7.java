package leetcode;

public class Solution7 {
    /**
     * x % 10  获取个位数字
     * x / 10  去掉个位数字
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        Long result = 0L;
        int num = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result.intValue() == result ? result.intValue() : 0;
    }

    /**
     * 字符串反转,效率很低
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        String s = new StringBuffer(String.valueOf(Math.abs(x))).reverse().toString();//取绝对值，然后字符串反转，最后判断需不需要加负号
        int flag = x < 0 ? -1 : 1;
        try {
            return Integer.parseInt(s) * flag;
        } catch (Exception e) {
            return 0;
        }
    }


    public static void main(String[] args) {
        reverse2(-1123456789);
    }
}
