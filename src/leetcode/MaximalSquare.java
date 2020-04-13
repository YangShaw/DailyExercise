package leetcode;

public class MaximalSquare {

    //  DP方法
    //  方程：min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
    //  说实话这个方程我没看懂
    public int maximalSquareDP(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        //  为了用初值0，所以dp数组扩大一圈
        int[][] dp = new int[row + 1][col + 1];
        int maxle = 0;
        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxle = Math.max(maxle, dp[i][j]);
                }
            }
        }
        return maxle * maxle;
    }

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }

        int col = matrix[0].length;

        int side = row < col ? row : col;

        for (; side > 0; --side) {
            //  遍历判断边长从side到1的正方形是否存在
            int end2 = row - side + 1;
            int end = col - side + 1;
            for (int i = 0; i < end2; ++i) {
                for (int j = 0; j < end; ++j) {
                    if (isLegal(i, j, side, matrix)) {
                        //System.out.println(i+"\t"+j);
                        return side * side;
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isLegal(int starti, int startj, int side, char[][] matrix) {
        int l1 = side + starti;
        int l2 = side + startj;
        for (int i = starti; i < l1; i++) {
            for (int j = startj; j < l2; j++) {
                if (matrix[i][j] == '0') {
                    //System.out.println("wrong in side "+side+" and [ "+i+"\t"+j+"\t");
                    return false;
                }
            }
        }
        return true;
    }
}
