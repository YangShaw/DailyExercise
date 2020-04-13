package leetcode;

public class Remove_Duplicates_26 {

    public static int solution(int[] nums) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; ) {
            int val = nums[i];

            //	����Ҫ��ԭ��������ƶ���ֱ�Ӱ�ԭ������ȫ��дһ�顣��ֹ�ƶ����ֵ��鷳
            //	���˼·�뵽���ݿ��к������ݵ���ɾ�Ĳ�ȡ���ʱ�����¹����������ܱ��޸���������
            nums[count] = val;
            ++count;
            int j;
            for (j = i + 1; j < n; j++) {
                if (nums[j] != val)
                    break;
            }
            i = j;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8};
        System.out.println(solution(nums));
    }

}
