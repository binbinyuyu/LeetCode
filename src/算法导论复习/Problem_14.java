package 算法导论复习;

public class Problem_14 {
    public static void main(String[] args) {
        String s = "you are a student.";
        System.out.println(inverseWords(s));
    }

    /**
     * 用空格分割字符串，然后再反着拼过来
     *
     * @param s
     * @return
     */
    public static String inverseWords(String s) {
        String[] split = s.split(" ");
        String result = "";
        for (int i = split.length - 1; i > 0; i--) {
            result += split[i] + " ";
        }
        result += split[0];
        return result;
    }
}
