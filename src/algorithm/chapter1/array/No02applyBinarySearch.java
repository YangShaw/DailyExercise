package algorithm.chapter1.array;

/**
 * @author YangShaw
 * @date 2021/3/30 20:16
 */
public class No02applyBinarySearch {

    /**
     * 1011 送包裹
     */
    public int shipWithinDays(int[] weights, int day) {
        int min = getMax(weights);
        int max = sum(weights);
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canFinish2(weights, day, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean canFinish2(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length)
                    return true;
            }
        }
        return false;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * 875 吃香蕉的keke
     */
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = getMax(piles);
        // 二分查找，找左边界
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canFinish(piles, h, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }

    private boolean canFinish(int[] nums, int h, int speed) {
        int count = 0;
        for (int num : nums) {
            if (num <= speed) {
                count++;
            } else {
                count = count + num / speed + (num % speed == 0 ? 0 : 1);
            }
        }
        return count <= h;
    }

    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }
}
