package leetcode;

public class Remove_Element_27 {

    public static int solution(int[] nums, int val) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
