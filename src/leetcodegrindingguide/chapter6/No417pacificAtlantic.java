package leetcodegrindingguide.chapter6;

import java.util.ArrayList;
import java.util.List;

public class No417pacificAtlantic {


    public boolean toPacific(int[][] heights, int i, int j, int before) {
        if (i == -1 || j == -1) {
            return true;
        }

        if (i == heights.length || j == heights[0].length) {
            return false;
        }

        if (heights[i][j] == -1 || heights[i][j] > before) {
            return false;
        }

        int backup = heights[i][j];
        heights[i][j] = -1;

        boolean result = toPacific(heights, i+1, j, backup) || toPacific(heights, i, j+1, backup)
                || toPacific(heights, i, j-1, backup) || toPacific(heights, i-1, j, backup);
        heights[i][j] = backup;
        return result;
    }

    public boolean toAtlantic(int[][] heights, int i, int j, int before) {
        if (i == heights.length || j == heights[0].length) {
            return true;
        }

        if (i == -1 || j == -1) {
            return false;
        }

        if (heights[i][j] == -1 || heights[i][j] > before) {
            return false;
        }

        int backup = heights[i][j];
        heights[i][j] = -1;

        boolean result = toAtlantic(heights, i+1, j, backup) || toAtlantic(heights, i, j+1, backup)
                || toAtlantic(heights, i, j-1, backup) || toAtlantic(heights, i-1, j, backup);
        heights[i][j] = backup;
        return result;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        if (m == 0) {
            return null;
        }
        int n = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = heights[i][j];
                boolean canPacific = toPacific(heights, i, j, cur);
                boolean canAtlantic = toAtlantic(heights, i, j, cur);
                if (canPacific && canAtlantic) {
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
