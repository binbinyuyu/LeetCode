package 算法导论复习;

/**
 * 两次二分，分别找到最左侧和最右侧的位置
 */
public class Problem_5 {
    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 5, 7, 7, 8, 9, 9, 9, 9};
        System.out.println(findCount(arrays, 0, arrays.length - 1, 9));
    }

    public static int findCount(int[] arrays, int left, int right, int target) {
        int leftPos = findLeftPos(arrays, left, right, target);
        int rightPos = findRightPos(arrays, left, right, target);
        return leftPos != -1 ? rightPos - leftPos + 1 : -1;
    }


    /**
     * 找到数最左侧的位置
     */
    public static int findLeftPos(int[] arrays, int left, int right, int target) {
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arrays[mid] > target) {
                right = mid - 1;
            } else if (arrays[mid] < target) {
                left = mid + 1;
            } else {//arrays[mid] == target
                //和前一个元素互相比较，如果和前一个元素不相等，则继续二分
                if (mid == 0 || arrays[mid - 1] != target) {
                    pos = mid;
                    break;
                } else
                    right = mid - 1;
            }
        }
        return pos;
    }

    /**
     * 找到数最右侧的位置
     */
    public static int findRightPos(int[] arrays, int left, int right, int target) {
        int pos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arrays[mid] > target) {
                right = mid - 1;
            } else if (arrays[mid] < target) {
                left = mid + 1;
            } else {//arrays[mid] == target
                //和后一个元素互相比较，如果和前一个元素不相等，则继续二分
                if (mid == arrays.length - 1 || arrays[mid + 1] != target) {
                    pos = mid;
                    break;
                } else
                    left = mid + 1;
            }
        }
        return pos;
    }
}
