package algorithm.classicalgs;

/**
 * @author YangShaw
 * @date 2021/4/7 15:53
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        // 置中的数字
        int key = array[left];
        while (i < j) {
            while (key <= array[j] && i < j) {
                j--;
            }
            while (key >= array[i] && i < j) {
                i++;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 使key归位
        array[left] = array[i];
        array[i] = key;
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 8, 9, 4, 3};
        quickSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
