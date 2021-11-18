package leetcode;

public class Solution66 {
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int newVal = 0;
            if (i == digits.length - 1)
                newVal = digits[i] + 1 + carry;
            else
                newVal = digits[i] + carry;
            carry = 0;
            if (newVal >= 10) {
                carry = newVal / 10;
                newVal %= 10;
            }
            digits[i] = newVal;
        }

        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }

            return result;
        } else
            return digits;
    }

    /**
     * 官方解答
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3};
        plusOne(data);
    }
}
