package javatest;

import java.util.*;

public class Problem3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = s.nextInt();
        }

        int max = nums[n - 1];
        int result = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] > max) {
                max = nums[i];
            } else {
                int temp = max - nums[i];
                if (temp > result) {
                    result = temp;
                }
            }
        }
        System.out.println(result);
    }

}
