package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest215 {

    //  使用优先级队列来模拟堆
    public int findKthLargest2(int[] nums, int k) {
        //  优先级队列，自定义优先级的判定方式，每次从队列中取出的是优先级最高的元素
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                //  写成小根堆，poll丢掉头上的元素，也就是最小的
                heap.poll();
            }
        }
        return heap.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
