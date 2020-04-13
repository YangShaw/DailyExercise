package javatest;

import java.util.*;

public class Problem4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();


        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = s.nextInt();
        }
        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }

        int count = n / 2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int temp = map.get(num);
                if (temp >= count) {
                    System.out.println(num);
                    return;
                }
                map.put(num, temp + 1);

            } else {
                map.put(num, 1);
            }
        }

    }

}
