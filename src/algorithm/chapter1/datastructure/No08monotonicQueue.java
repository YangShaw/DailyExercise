package algorithm.chapter1.datastructure;

import java.util.LinkedList;

/**
 * 单调队列，解决滑动窗口问题
 * @author YangShaw
 * @date 2021/3/29 6:29
 */
public class No08monotonicQueue {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int count = 0;
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                // i = k-1的时候，窗口就满了，开始找第一次最大值
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                result[count++] = window.max();
                // 判断一下窗口最头上的是否是最大值, 若是则出队
                window.pop(nums[i - k + 1]);
            }
        }
        return result;
    }

    class MonotonicQueue {
        // 双向队列
        LinkedList<Integer> queue = new LinkedList<>();

        // 单调栈，要把末尾中比n小的都挪出去
        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) {
                // 移除末位
                queue.pollLast();
            }
            queue.addLast(n);
        }

        public int max() {
            // 单调栈，max就是头上的元素
            return queue.getFirst();
        }

        public void pop(int n) {
            // 删除头上的元素，但是这个元素可能在入队的时候因为太小就已经被干掉了，所以判断一下
            if (queue.getFirst() == n) {
                queue.pollFirst();
            }
        }
    }

}
