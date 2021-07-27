package interview0407Ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author YangShaw
 * @date 2021/4/7 8:52
 */
public class Problem1 {
    private static long invert(String str) {
        boolean flag = false;
        if (str.charAt(0) == '-') {
            flag = true;
            str = str.substring(1);
        }
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(map.get(c));
        }
        long num = Long.valueOf(sb.toString());
        if (flag) {
            num = -1 * num;
        }
        return num;
    }

    private static String encode(long num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            str = str.substring(1);
            sb.append("-");
        }
        char[] array = str.toCharArray();
        for (char c : array) {
            sb.append(pattern[c - '0']);
        }
        return sb.toString();
    }
    private static Map<Character, Integer> map;
    private static String[] pattern = {")", "!", "@", "#", "$", "%", "^", "&", "*", "("};
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        map = new HashMap<>();
        map.put(')', 0);
        map.put('!', 1);
        map.put('@', 2);
        map.put('#', 3);
        map.put('$', 4);
        map.put('%', 5);
        map.put('^', 6);
        map.put('&', 7);
        map.put('*', 8);
        map.put('(', 9);
        for (int i = 0; i < n; i++) {
            // 读取n组数字
            String a = s.next();
            String b = s.next();
            long numA = invert(a);
            long numB = invert(b);
            System.out.println(encode(numA + numB));
            System.out.println(encode(numA - numB));
            System.out.println(encode(numB - numA));
        }
    }
}
