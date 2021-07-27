package algorithm.chapter1.array;

/**
 * @author YangShaw
 * @date 2021/3/30 9:59
 */
public class No01binarySearch {

    /**
     * 基本的二分查找找目标值
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // 初始的right是有效的索引（而非nums.length），所以使用<=来确保能够读取到right位
        while (left <= right) {
            // 比直接使用left + right更好，防止溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界
     */
    public int bsLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 因为是找左侧边界，所以相同的时候，还是往左边找
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}
