package leetcode;

public class GenerateMatrix59 {

    public int[][] generateMatrix(int n) {
        //	���ɴ�1-n^2����������

        int[][] matrix = new int[n][n];
        int fromL = 0;
        int fromU = 1;
        int fromR = n - 2;
        int fromD = n - 2;

        int num = 1;
        int target = n * n + 1;
        while (true) {
            for (int i = fromL; i < fromR + 2; ++i) {
                matrix[fromU - 1][i] = num;
                num++;
            }
            if (num == target) {
                break;
            }
            fromL++;

            for (int i = fromU; i < fromD + 2; ++i) {
                matrix[i][fromR + 1] = num;
                num++;
            }
            if (num == target) {
                break;
            }
            fromU++;

            for (int i = fromR; i > fromL - 2; --i) {
                matrix[fromD + 1][i] = num;
                num++;
            }
            if (num == target) {
                break;
            }
            fromR--;

            for (int j = fromD; j > fromU - 2; --j) {
                matrix[j][fromL - 1] = num;
                num++;
            }
            if (num == target) {
                break;
            }
            fromD--;
        }


        return matrix;

    }

}
