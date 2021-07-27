package algorithm.chapter3.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author YangShaw
 * @date 2021/4/9 23:26
 */
public class No02openLock {

    private int[] addOffset(int[] origin, int[] offset) {
        int[] sums = new int[4];
        for (int i = 0; i < 4; i++) {
            sums[i] = origin[i] + offset[i];
            if (sums[i] > 9) {
                sums[i] -= 10;
            }
        }
        return sums;
    }
    private String numToStr(int[] nums) {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            num.append(nums[i]);
        }
        return num.toString();
    }
    private boolean isTarget(String target, String num) {
        return target.equals(num);
    }
    private boolean isValid(String[] deadends, String num) {
        for (int i = 0; i < deadends.length; i++) {
            if (deadends[i].equals(num)) {
                return false;
            }
        }
        return true;
    }
    public int openLock(String[] deadends, String target) {
        int[][] offsets = {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {0,0,0,1},
                {9,0,0,0},
                {0,9,0,0},
                {0,0,9,0},
                {0,0,0,9}
        };
        int[] init = {0,0,0,0};
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        queue.add(init);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int[] nums = addOffset(current, offsets[j]);
                    String strNum = numToStr(nums);
                    if (isTarget(target, strNum)) {
                        return step;
                    }
                    if (isValid(deadends, strNum) || visited.contains(strNum)) {
                        // 有效，继续向下搜索
                        visited.add(strNum);
                        queue.add(nums);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
