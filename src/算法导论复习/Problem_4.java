package 算法导论复习;

public class Problem_4 {
    public static void findTheFakeCoin(int[] A, int left, int right) {
        int cA = 0, cB = 0;
        int tempR = (left + right) / 2;
        for (int i = left; i <= tempR; i++) {
            if (i <= (left + tempR) / 2)
                cA += A[i];
            else
                cB += A[i];
        }
        if (cA == cB) {
            for (int i = tempR + 1; i <= right; i++)
                if (A[left] - A[i] > 0)
                    System.out.print("假币较轻，是第" + (i + 1) + "枚，假币的重量是" + A[i]);
                else if (A[left] - A[i] < 0)
                    System.out.print("假币较重，是第" + (i + 1) + "枚，假币的重量是" + A[i]);

        } else if (cA > cB) {
            if (tempR - left == 3) {
                if (A[left] + A[tempR] > A[left + 1] + A[tempR - 1]) {
                    if (A[left] == A[tempR])
                        System.out.print("假币较轻，是第" + tempR + "枚，假币的重量是" + A[tempR - 1]);
                    else
                        System.out.print("假币较重，是第" + (left + 1) + "枚，假币的重量是" + A[left]);
                } else {
                    if (A[left] == A[tempR])
                        System.out.print("假币较重，是第" + (left + 2) + "枚，假币的重量是" + A[left + 1]);
                    else
                        System.out.print("假币较轻，是第" + (tempR + 1) + "枚，假币的重量是" + A[tempR]);
                }
            } else {
                findTheFakeCoin(A, left, tempR);
                findTheFakeCoin(A, tempR + 1, right);
            }

        } else {
            if (tempR - left == 3) {
                if (A[left] + A[tempR] > A[left + 1] + A[tempR - 1]) {
                    if (A[left] == A[tempR])
                        System.out.print("假币较轻，是第" + (left + 2) + "枚，假币的重量是" + A[left + 1]);
                    else
                        System.out.print("假币较重，是第" + (tempR + 1) + "枚，假币的重量是" + A[tempR]);
                } else {
                    if (A[left] == A[tempR])
                        System.out.print("假币较重，是第" + tempR + "枚，假币的重量是" + A[tempR - 1]);
                    else
                        System.out.print("假币较轻，是第" + (left + 1) + "枚，假币的重量是" + A[left]);
                }
            } else {
                findTheFakeCoin(A, left, tempR);
                findTheFakeCoin(A, tempR + 1, right);
            }
        }
    }

    public static void main(String args[]) {
        int[] coins = new int[]{2, 2, 2, 2, 1, 2, 2, 2};
        int cA = 0;
        int cB = 0;

        findTheFakeCoin(coins, 0, 7);
    }
}
