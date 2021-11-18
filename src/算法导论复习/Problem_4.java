package 算法导论复习;

//https://blog.csdn.net/engerla/article/details/80508045?ops_request_misc=&request_id=&biz_id=102&utm_term=%E5%81%87%E5%B8%81%E9%97%AE%E9%A2%98&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-80508045.nonecase&spm=1018.2226.3001.4187
public class Problem_4 {
    public static void main(String args[]) {
        int[] coins = new int[]{2, 2, 2, 2, 2, 5, 2, 2, 2};
        int pos = findTheFakeCoin(coins, 0, coins.length - 1);
        System.out.println("假币位置为：" + pos + ",重量为：" + coins[pos]);
    }

    /**
     * 二分法
     *
     * @param coins
     * @param left
     * @param right
     */
    public static int findTheFakeCoin(int[] coins, int left, int right) {
        int length = right - left + 1;//本次要比较的长度
        int pos = -1;//假币的位置
        if (length == 1) {//要比较的硬币只剩下最后一枚
            //将它和另一个硬币（非上一轮比较的那个）比较，这里选距它2个的那个硬币进行比较
            int weight = (left - 2 >= 0 && left - 2 < coins.length) ? coins[left - 2] : coins[left + 2];
            if (coins[left] != weight)
                pos = left;
        } else if (length % 2 == 0) {//要比较的长度为偶数，继续二分
            int leftSum = sum(coins, left, left + length / 2 - 1);
            int rightSum = sum(coins, left + length / 2, right);
            if (leftSum != rightSum) {//两部分质量不相等，说明那个假币就在某一堆里面
                pos = findTheFakeCoin(coins, left, left + length / 2 - 1);
                if (pos == -1)
                    pos = findTheFakeCoin(coins, left + length / 2, right);
            }
        } else {//要比较的长度为奇数，先继续二分，然后单独比较那个元素
            pos = findTheFakeCoin(coins, left + 1, right);
            if (pos == -1) {//说明剩下的全是真币
                if (coins[left] != coins[left + 1])
                    pos = left;
            }
        }
        return pos;
    }

    /**
     * 求数组下标left到right的和
     *
     * @param coins
     * @param left
     * @param right
     * @return
     */
    public static int sum(int[] coins, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += coins[i];
        }
        return sum;
    }
}
