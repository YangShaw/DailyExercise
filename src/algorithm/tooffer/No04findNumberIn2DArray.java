package algorithm.tooffer;

/**
 * @author YangShaw
 * @date 2021/4/13 23:44
 */
public class No04findNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从左下角开始，往上变小，往右变大
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;

        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < m) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                row--;
            } else if (cur < target) {
                col++;
            }
        }
        return false;
    }
}
