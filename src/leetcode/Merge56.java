package leetcode;

import java.util.Arrays;

public class Merge56 {

    public int[][] merge(int[][] intervals){
        //使用lambda来传入一个自定义的Comparator
        Arrays.sort(intervals, (v1,v2)->v1[0]-v2[0]);
        int l = intervals.length;
        int[][] result = new int[l][2];
        int index = -1;

        for(int[] interval: intervals){
            // 第一个数组 或者后一个区间的起点大于前一个区间的终点的情况，直接插入result
            if(index==-1 || interval[0]>result[index][1]){
                result[++index] = interval;
            } else {
                // 否则要进行合并
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }
        // 这里的第二个参数是长度，所以要比序号+1
        return Arrays.copyOf(result, index+1);
    }
}
