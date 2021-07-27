package algorithm.chapter2.greedy;

import java.util.Arrays;

/**
 * @author YangShaw
 * @date 2021/4/19 17:26
 */
public class Intervals {

    // 452
    public int findMinArrowShots(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            // 防止溢出，不能直接相减
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return count;
    }

    // 435
    public int eraseOverlapIntervals(int[][] intervals) {
        // 根据结束时间升序排列
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        // 初始
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;
    }
}
