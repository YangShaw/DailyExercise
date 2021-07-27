package interview0411meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YangShaw
 * @date 2021/4/11 10:30
 */
public class Problem4 {

    public static char isValid(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 0) {
            if(arr[n/2] == arr[n/2-1]) {
                return arr[n/2];
            } else {
                return '*';
            }
        } else {
            if(arr[0] == arr[n/2] || arr[n-1] == arr[n/2]) {
                return arr[n/2];
            } else {
                return '*';
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
        str = "*" + str;
        int res = 0;
        char[] flag = new char[n + 1];
        Arrays.fill(flag, '*');
        for (int i = 1; i <= n; i++) {
            // 每轮的首位
            flag[i] = str.charAt(i);
            res++;
            for (int j = i+1; j <= n; j++) {
                String cur = str.substring(i, j+1);
                // 和上面的相同
                if (str.charAt(j) == flag[j-1]) {
                    res++;
                    flag[j] = flag[j-1];
                } else if (str.charAt(i-1) != flag[j]) {
                    res++;
                } else {
                    // 符合
                    char t = isValid(cur);
                    if (t == '*') {
                        flag[j] = '*';
                    } else {
                        res++;
                        flag[j] = t;
                    }
                }
            }

        }
        System.out.println(res);
    }
}
