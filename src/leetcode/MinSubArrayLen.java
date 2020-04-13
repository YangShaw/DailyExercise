package leetcode;

import java.util.Scanner;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] array) {

        int n = array.length;
        if (n == 0) {
            return 0;
        }

        int start = 0;
        int end = 1;
        int sum = array[0];
        int count = 1;
        int min = n;
        boolean flag = false;
        while (start < end && end < n) {
            while (sum < target && end < n) {
                //	û������С�����������
                sum = sum + array[end];
                end++;
                count++;
            }
            while (sum >= target && start < end) {
//					�����ˣ�����ǰ���ܲ�����һ��
                flag = true;
                sum = sum - array[start];
                start++;
                count--;
            }
            int temp = count + 1;
            if (temp < min) {
                min = temp;
            }

        }
        if (flag) {
            return min;
        } else {
            return 0;
        }
    }
}
