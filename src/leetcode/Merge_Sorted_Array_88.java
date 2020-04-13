package leetcode;

public class Merge_Sorted_Array_88 {

    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int l = m + n - 1;
        int one = m - 1, two = n - 1;    //	��־�������鵱ǰָ��λ�ã��Ӻ���ǰ��

        //	�Ӻ���ǰ�洢���ܾ�������ǰ����ƶ�
        while (one >= 0 && two >= 0) {
            if (nums1[one] > nums2[two]) {
                nums1[l] = nums1[one];
                one--;
            } else {
                nums1[l] = nums2[two];
                two--;
            }
            l--;
        }

        //	��Ϊʱ��two���뵽one�����Կ���two���Ƿ���ʣ�µġ�
        if (two >= 0) {
            for (int i = 0; i <= two; ++i) {
                nums1[i] = nums2[i];
            }
        }
    }

}
