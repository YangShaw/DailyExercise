package algorithm.chapter3.traverse;

/**
 * @author YangShaw
 * @date 2021/4/9 18:32
 */
public class No05sudoku {

    // 数独
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    public boolean backTrack(char[][] board, int i, int j) {
        // base case
        if (i == 9) {
            return true;
        }
        // next row
        if (j == 9) {
            return backTrack(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return backTrack(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; ) {
            // 同行
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (backTrack(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
            c = (char)(c++);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        // same row
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) {
                return false;
            }
        }
        // same column
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c) {
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (board[(i/3)*3 + k/3][(j/3)*3 + i%3] == c) {
                return false;
            }
        }
        // same block
        //int rStart = i - i % 3;
        //int rEnd = rStart + 3;
        //int cStart = j - j % 3;
        //int cEnd = cStart + 3;
        //for (int m = rStart; m < rEnd; m++) {
        //    for (int n = cStart; n < cEnd; c++) {
        //        if (board[m][n] == c) {
        //            return false;
        //        }
        //    }
        //}
        return true;
    }

}
