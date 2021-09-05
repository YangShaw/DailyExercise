package leetcodegrindingguide.chapter6;

import java.util.ArrayList;
import java.util.List;

public class No417pacificAtlantic2 {

    public void canReach(int[][] heights, int i, int j, boolean[][] toSw) {
        if (i == -1 || j == -1 || i == heights.length || j == heights[0].length
            || toSw[i][j]) {
            return;
        }

        toSw[i][j] = true;
        canReach(heights, i+1, j, toSw);
        canReach(heights, i, j+1, toSw);
        canReach(heights, i-1, j, toSw);
        canReach(heights, i, j-1, toSw);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        if (m == 0) {
            return null;
        }
        int n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] toP = new boolean[m][n];
        boolean[][] toA = new boolean[m][n];

        // 上边和下边
        for (int j = 0; j < n; j++) {
            canReach(heights, 0, j, toP);
            canReach(heights, 0, j, toA);
            canReach(heights, m-1, j, toP);
            canReach(heights, m-1, j, toA);
        }

        for (int i = 1; i < m-1; i++) {
            canReach(heights, i, 0, toP);
            canReach(heights, i, 0, toA);
            canReach(heights, i, n-1, toP);
            canReach(heights, i, n-1, toA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (toP[i][j] && toA[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }

        return result;

    }
}
