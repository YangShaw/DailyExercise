package algorithm.tooffer;

/**
 * @author YangShaw
 * @date 2021/4/14 0:23
 */
public class No11minArray {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                // 因为我要找的是最小的位置，所以当前大的时候，可以跳过这一位
                left = mid + 1;
            } else if (numbers[mid] < numbers[left]) {
                right = mid;
            } else {
                // 避免死循环
                right--;
            }
        }
        return numbers[left];
    }
}
