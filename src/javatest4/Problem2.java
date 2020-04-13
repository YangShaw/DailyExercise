package javatest4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            int temp = s.nextInt();
            list.add(temp);
        }
        ArrayList<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        int min = n - 1, max = 0;
        for (int i = 0; i < n; ++i) {
            //  逐个比对数字
            if (list.get(i) != sorted.get(i)) {
                min = i;
                break;
            }
        }
        if (min == n - 1) {
            //  原本就有序
            System.out.println(0);
            return;
        }

        for (int i = n - 1; i > min; --i) {
            if (list.get(i) != sorted.get(i)) {
                max = i;
                break;
            }
        }
        System.out.println(max - min + 1);

    }
}
