package algorithm.chapter3.traverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/4/9 9:46
 */
public class No02nQueens {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> track = new ArrayList<>();
        int[] pos = new int[n];
        Arrays.fill(pos, -1);
        backTrack(n, track, pos);
        return result;
    }

    private boolean isValid(int i, int cur, int[] pos) {
        for (int j = 0; j < cur; j++) {
            // 是否在同一列
            if (pos[j] == i) {
                return false;
            }
            // 是否在同斜行
            if ((cur - j) == Math.abs(i - pos[j])) {
                return false;
            }
        }
        return true;
    }

    public void backTrack(int n, List<String> track, int[] pos) {
        if (track.size() == n) {
            result.add(new ArrayList<>(track));
            return;
        }

        int cur = track.size();
        // 每一行都有8个选择
        for (int i = 0; i < n; i++) {
            if (!isValid(i, cur, pos)) {
                continue;
            }
            pos[cur] = i;
            // 构造序列
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            // 注意做选择和撤销选择都是在for循环之中
            track.add(sb.toString());
            backTrack(n, track, pos);
            pos[cur] = -1;
            track.remove(track.size() - 1);
        }
    }
}
