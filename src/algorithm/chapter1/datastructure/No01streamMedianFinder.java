package algorithm.chapter1.datastructure;

import java.util.PriorityQueue;

/**
 *
 * 查找数据流的中位数
 * 使用两个堆，也就是两个优先级队列
 * @author YangShaw
 * @date 2021/3/24 23:50
 */
public class No01streamMedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public No01streamMedianFinder() {
        // 小根堆，存放较大的那些数，其中最小的那个是中间的部分
        large = new PriorityQueue<>();
        // 大根堆，存放较小的那些数，其中最大的那个是中间的部分
        small = new PriorityQueue<>((a, b) -> b - a);
    }

    public double findMedian() {
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 偶数的情况
        return (large.peek() + small.peek()) / 2.0;
    }

    public void addNum(int num) {
        if (large.size() >= small.size()) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
    }
}
