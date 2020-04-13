package javatest2;

import java.util.*;

public class Problem2 {

    //	static int[][] array;
    static int cur;
//	static int count;

    static void toR(int start, int end, int row, int[][] array) {
        for (int i = start; i < end; ++i) {
            System.out.print(array[row][i] + " ");
        }
    }

    static void toD(int start, int end, int column, int[][] array) {
        for (int j = start; j < end; ++j) {
            System.out.print(array[j][column] + " ");
        }
    }

    static void toL(int start, int end, int row, int[][] array) {
        for (int i = start; i > end; --i) {
            System.out.print(array[row][i] + " ");
        }
    }

    static void toU(int start, int end, int column, int[][] array) {
        for (int j = start; j > end; --j) {
            System.out.print(array[j][column] + " ");
        }
    }

    static boolean hasFinished(int start, int end, int count) {
        cur = cur + end - start;
        if (cur == count) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int count = m * n;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                array[i][j] = s.nextInt();
            }
        }

        int fromL = 0;    //	�������ҵ����
        int fromU = 1;    //	�������µ����
        int fromR = n - 2;    //	������������
        int fromD = m - 2;    //	�������ϵ����
        cur = 0;
        while (true) {
            toR(fromL, fromR + 2, fromU - 1, array);
            if (hasFinished(fromL, fromR + 2, count)) {
                break;
            }
            fromL++;    //	������������һ��֮����һ���������Ųһλ

            toD(fromU, fromD + 2, fromR + 1, array);
            if (hasFinished(fromU, fromD + 2, count)) {
                break;
            }
            fromU++;

            toL(fromR, fromL - 2, fromD + 1, array);
            if (hasFinished(fromL - 2, fromR, count)) {
                break;
            }
            fromR--;

            toU(fromD, fromU - 2, fromL - 1, array);
            if (hasFinished(fromU - 2, fromD, count)) {
                break;
            }
            fromD--;
        }

    }

}
