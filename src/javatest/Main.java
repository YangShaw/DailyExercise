package javatest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = s.nextInt();
        }
        int target = s.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], i);

        }
        for (int i = 0; i < nums.length; ++i) {
            int num = target - nums[i];
            if (map.containsKey(num) && map.get(num) != i) {
                System.out.println(i + " " + map.get(num));
                return;
            }
        }

    }
}
