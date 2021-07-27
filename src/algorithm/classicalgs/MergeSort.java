package algorithm.classicalgs;

/**
 * @author YangShaw
 * @date 2021/4/7 16:01
 */
public class MergeSort {

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1, new int[array.length]);
    }

    public static void mergeSort(int[] array, int left, int right, int[] result) {
        if (left >= right) {
           return;
        }
        int mid = left + (right - left) / 2;
        int s1 = left, e1 = mid;
        int s2 = mid + 1, e2 = right;
        mergeSort(array, left, mid, result);
        mergeSort(array, mid + 1, right, result);
        // 插入result的次序
        int index = left;
        while (s1 <= e1 && s2 <= e2) {
            result[index++] = array[s1] < array[s2] ? array[s1++] : array[s2++];
        }
        while (s1 <= e1) {
            result[index++] = array[s1++];
        }
        while (s2 <= e2) {
            result[index++] = array[s2++];
        }
        for (index = left; index <= right; index++) {
            array[index] = result[index];
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 8, 9, 4, 3};
        mergeSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
