package leetcode;

public class Max_Subarray_53 {


    //	����˼·������Ͻ������Ǹ��Ӷ�����
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            result = Math.max(sum, result);
        }
        return result;
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        int i, j;
        int value = Integer.MIN_VALUE;
        for (i = 0; i < n; ) {
            //	i��һ�������еĿ�ͷ�������ͷ�Ǹ�����ֱ�Ӳ��ÿ��ˡ�
            if (nums[i] > value)
                value = nums[i];
            if (nums[i] <= 0) {    //
                ++i;
                continue;
            }
            int sum = nums[i];    //	�ӵ�ǰ��ʼ���

            for (j = i + 1; j < n; j++) {    //	��i����һ��λ�ÿ�ʼ��
                if (nums[j] + sum <= 0) {    //	����������粻��
                    if (value < sum) {
                        value = sum;    //	��ǰ���ֵ����Ȼ��һ��Ҫ�����ˣ�������ǰ��Ŀ���ȷʵ�������ˡ�
                    }
                    i = j + 1;
                    break;    //	������һ�����Ӻ��濪ʼ
                }
                if (nums[j] < 0) {
                    if (value < sum) {
                        value = sum;    //	���ֵ�Ǹ������Ǿ��ȴ�һ�£��������滹�᲻���и����
                    }
                    sum = sum + nums[j];
                } else {
                    sum = sum + nums[j];
                    if (sum > value) {
                        value = sum;
                    }
                }
            }
            if (j == n) return value;
        }
        return value;
    }

    public static void main(String[] args) {

        int nums[] = {1};
        System.out.println(solution(nums));
    }

}
