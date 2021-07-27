package algorithm.classicalgs;

/**
 * @author YangShaw
 * @date 2021/4/13 9:47
 */
public class HeapSort {

    public void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            // 根元素（最大元素）和末尾元素交换位置
            swap(array, 0, i);
            // 这时候，末尾元素已经是最大的了，不用管它，所以长度相当于变成了原来的length-1,刚好是i
            // 根元素是原来的末尾元素，需要重新调整一波
            adjustEle(array, 0, i);
        }
    }

    public void buildMaxHeap(int[] array) {
        // 这个起始索引是第一个非叶子节点
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustEle(array, i, array.length);
        }
    }

    public void adjustEle(int[] array, int i, int length) {
        int temp = array[i];
        // for循环的目的在于，每次若当前节点比子节点小，那么交换之，再替换到子节点的地方去看，因为下层
        // 可能受到了影响也需要调整，所以k = k*2 + 1
        for (int k = 2*i + 1; k < length; k = k*2 + 1) {
            // 判断左右节点谁更大
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            // 交换父子节点
            if (array[k] > temp) {
                swap(array, k, i);
                i = k;
            } else {
                break;
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {87, 45, 78, 32, 128, 17, 65, 53, 9};
        HeapSort hs = new HeapSort();
        hs.buildMaxHeap(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        hs.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
