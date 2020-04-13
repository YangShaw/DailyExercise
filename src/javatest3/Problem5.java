package javatest3;

import java.util.Scanner;

public class Problem5 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int down = s.nextInt();
        int right = s.nextInt();
        if (down == 1 || right == 1) {
            System.out.println(1);
            return;
        }

        int[][] result = new int[down + 1][right + 1];
        //result[0][0] = 0;
        for (int i = 0; i < down + 1; ++i) {
            result[i][1] = 1;
        }
        for (int i = 0; i < right + 1; ++i) {
            result[1][i] = 1;
        }
        for (int i = 2; i < down + 1; ++i) {
            for (int j = 2; j < right + 1; ++j) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        System.out.println(result[down][right]);

    }
}
