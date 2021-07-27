package algorithm.classicalgs;

import java.util.Arrays;

/**
 * @author YangShaw
 * @date 2021/4/18 17:13
 */
public class Span {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        return null;
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            int templ = temp[0];
            int tempr = temp[1];
            if (left <= templ && right >= tempr) {
                // 包含区间
                res++;
            } else if (right <= templ) {
                // 没有关系，跳到下一个
                left = templ;
                right = tempr;
            } else if (templ <= right && tempr >= right) {
                // 合并成大的
                right = tempr;
            }
        }
        return intervals.length - res;
    }
}
