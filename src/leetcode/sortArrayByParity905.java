package leetcode;

public class sortArrayByParity905 {

    public int[] sortArrayByParity2(int[] a) {
        int l = a.length;
        int[] result = new int[l];
        int j = 0;
        for (int i = 0; i < l; ++i) {
            if (a[i] % 2 == 0) {
                result[j++] = a[i];
            }
        }

        for (int i = 0; i < l; ++i) {
            if (a[i] % 2 != 0) {
                result[j++] = a[i];
            }
        }

        return result;
    }

    public int[] sortArrayByParity(int[] a) {
        int l = a.length;
        int left = 0;
        int right = l - 1;    //	˫ָ�����ͷ��ʼ����

        while (left < right) {
            while (left < l - 1 && a[left] % 2 == 0) {
                //	�ҵ���ߵ�����
                left++;
            }
            while (right > 0 && a[right] % 2 != 0) {
                right--;
            }

            if (left == l - 1 || right == 0 || right <= left) {
                return a;
            }

            // swap
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        return a;
    }
}
