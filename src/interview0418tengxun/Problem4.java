package interview0418tengxun;

import java.util.Scanner;

/**
 * @author YangShaw
 * @date 2021/4/18 20:14
 */
public class Problem4 {

    public static boolean compare(String s1, String s2) {
        // 不管jiou，只要完全相等，一定true
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        // jishu
        if (len % 2 == 1) {
            //一定false，因为不相等
           return false;
        }
        // oushu
        int half = len / 2;
        String s1left = s1.substring(0, half);
        String s1right = s1.substring(half);
        String s2left = s2.substring(0, half);
        String s2right = s2.substring(half);
        // 同侧比较
        boolean llrr = compare(s1left, s2left) && compare(s1right, s2right);
        if (llrr) {
            return true;
        }
        // 异侧比较
        return compare(s1left, s2right) && compare(s1right, s2left);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            String s1 = s.next();
            String s2 = s.next();
            if (compare(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
