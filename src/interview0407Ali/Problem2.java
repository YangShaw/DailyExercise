package interview0407Ali;

import java.util.Scanner;

/**
 * @author YangShaw
 * @date 2021/4/7 8:52
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int[] record = new int[n];
        int[] indexes = new int[n];
        int max = 0;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < m; i++) {
            if (a[i] <= 0) {
                if (max < sum) {
                    max = sum;
                    index = i - 1;
                }
            }
            sum += a[i];
        }
        if (max < sum) {
            max = sum;
            index = m - 1;
        }
        record[0] = max;
        indexes[0] = index;
        for (int i = 1; i < n; i++) {
            if (a[i] <= 0) {
                record[i] = -1;
                indexes[i] = -1;
                continue;
            }
            int pre = record[i-1] - a[i-1];

        }
    }
}
