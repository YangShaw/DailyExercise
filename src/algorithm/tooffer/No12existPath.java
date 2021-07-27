package algorithm.tooffer;

/**
 * @author YangShaw
 * @date 2021/4/17 12:10
 */
public class No12existPath {
    // 路径按照上右下左
    // last按照下左上右
    private int[] pathx = {-1, 0, 1, 0};
    private int[] pathy = {0, 1, 0, -1};

    // 回溯法
    // 记录路径 每一步有选择
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[][] all = new char[m+2][n+2];
        m = m + 2;
        n = n + 2;
        // 边界
        for (int i = 0; i < m; i++) {
            all[i][0] = '*';
            all[i][n - 1] = '*';
        }
        for (int j = 1; j < n - 1; j++) {
            all[0][j] = '*';
            all[m - 1][j] = '*';
        }
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                all[i][j] = board[i-1][j-1];
            }
        }
        char[] target = word.toCharArray();
        int cur = 0;
        return solve(all, target, 0, 1, 1, 2);

    }

    public boolean solve(char[][] all, char[] target, int cur, int i, int j, int last) {
        if (cur == target.length) {
            return true;
        }
        // 直接返回
        if (all[i][j] != target[cur]) {
            return false;
        }
        cur++;
        // 四个方向走
        boolean flag = false;
        for (int p = 0; p < 3; p++) {
            // 不走回头路
            if (p != last) {
                flag = flag || solve(all, target, cur, i + pathx[p], j + pathy[p], (p + 2) % 4);
            }
        }
        return flag;
    }
}
