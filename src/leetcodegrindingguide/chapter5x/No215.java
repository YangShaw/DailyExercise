package leetcodegrindingguide.chapter5x;

public class No215 {

    public static void main(String[] args) {
        No215 cur = new No215();
        int[] nums = {3,2,1,4,5,6};
        int k = 2;
        System.out.println(cur.findKthLargest(nums, k));
    }
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        // 排序是升序的，但是第k大是降序的
        int target = nums.length - k;
        while (left < right) {
            System.out.println("left: "+left+"; right: "+right);
            int mid = quickSelection(nums, left, right);
            System.out.println("mid: "+mid);
            if (mid == target) {
                return nums[mid];
            }
            if (mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public int quickSelection(int[] nums, int left, int right) {
        int start = left;
        int end = right;
        int key = nums[left];
        while (start < end) {
            while (start < end && nums[end] >= key) {
                end--;
            }
            //找到结尾部分的某一个，不符合要求了，存到前面
            nums[start] = nums[end];
            while (start < end && nums[start] <= key) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
        return start;
    }
}
