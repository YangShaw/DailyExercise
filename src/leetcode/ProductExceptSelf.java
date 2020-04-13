package leetcode;

public class ProductExceptSelf {

    //  通过保存左积和右积的方法来计算
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        int curLeft = nums[0];
        for (int i = 1; i < n; ++i) {
            left[i] = curLeft;
            curLeft = curLeft * nums[i];
        }
        right[n - 1] = 1;
        int curRight = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = curRight;
            curRight = curRight * nums[i];
        }
        for (int i = 0; i < n; ++i) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
