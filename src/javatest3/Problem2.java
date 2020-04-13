package javatest3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; ++i) {
            array[i] = s.nextInt();

        }
        int k = s.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], i);
            } else {
                int len = i - map.get(array[i]);
                if (len <= k) {
                    System.out.println("true");
                    return;
                } else {
                    //  更新所在的位置
                    map.put(array[i], i);
                }
            }
        }
        System.out.println("false");
    }
}
