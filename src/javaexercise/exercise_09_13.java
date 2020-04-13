package javaexercise;

import java.util.Scanner;

public class exercise_09_13 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the array:");
        int r = s.nextInt();
        int c = s.nextInt();
        double[][] array = new double[r][c];
        System.out.println("Enter the array:");
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                array[i][j] = s.nextDouble();
            }
        }
        Location location = locateLargest(array);
        System.out.println("The location of the largest elemnet is " + location.maxValue
                + " at (" + location.row + ", " + location.column + ")");
    }

    public static Location locateLargest(double[][] a) {
        double max = Double.MIN_VALUE;
        int row = 0, column = 0;
        int r = a.length;
        int c = a[0].length;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (a[i][j] > max) {
                    row = i;
                    column = j;
                    max = a[i][j];
                }
            }
        }

        return new Location(row, column, max);
    }
}
