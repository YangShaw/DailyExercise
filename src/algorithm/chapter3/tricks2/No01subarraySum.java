package algorithm.chapter3.tricks2;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和技巧，频繁查询数组某个区间的和
 * @author YangShaw
 * @date 2021/4/10 23:40
 */
public class No01subarraySum {

    public int subarraySum(int[] nums, int k) {
        // 计算前缀和数组
        int n = nums.length;
        int[] pre = new int[n + 1];
        pre[0] = 0;
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (pre[i] - pre[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // 优化版 边走边算
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> pre = new HashMap<>();
        pre.put(0, 1);
        int n = nums.length;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 当前前缀和
            sum = sum + nums[i];
            // 目标前缀和
            int target = sum - k;
            if (pre.containsKey(target)) {
                res += pre.get(target);
            }
            pre.put(sum, pre.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
