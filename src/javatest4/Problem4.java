package javatest4;

import java.util.Scanner;

public class Problem4 {
    public static int[][] matrixMultiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = 0;
                for (int k = 0; k < n; ++k) {
                    temp = temp + a[i][k] * b[k][j];
                }
                result[i][j] = temp;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        if (n == 0) {
            return;
        }
        int[][] a = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = s.nextInt();
            }
        }
        if (m == 0) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == j) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
            return;
        }

        int[][] b = a;
        if (m == 4) {
            int[][] b1 = matrixMultiply(a, a);
            b = matrixMultiply(b1, b1);
        } else if (m == 5) {
            int[][] b1 = matrixMultiply(a, a);
            b = matrixMultiply(b1, b1);
            b = matrixMultiply(b, a);
        } else {
            for (int i = 1; i < m; ++i) {
                b = matrixMultiply(b, a);
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(b[i][j] + " ");
            }
            if (i != n - 1) {
                System.out.println();
            }
        }

    }
}
