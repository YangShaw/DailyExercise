package daily;

import java.util.*;

public class Question2 {

    public static void main(String[] args) {
        // input
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();    //��
        int m = s.nextInt();    //target

        if (m == n) {
            System.out.println(n);
        } else if (m < n) {
            compute(m, n);
        }
    }

    public static void compute(int m, int n) {
        System.out.println(n);
        int end = n;
        for (int i = 1; i < end; ++i) {
            int pair = m - i;
            end = pair;
            if (pair != i) {
                System.out.println(i + " " + pair);
            }
        }
    }

}
