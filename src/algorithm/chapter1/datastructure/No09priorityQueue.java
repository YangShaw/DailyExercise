package algorithm.chapter1.datastructure;

/**
 * 优先级队列，就是一个堆
 * @author YangShaw
 * @date 2021/3/29 14:14
 */
public class No09priorityQueue {

    public static void main(String[] args) {
        MaxPQ<Integer> queue = new MaxPQ<Integer>(10);
        queue.insert(4);
        queue.insert(5);
        queue.insert(1);
        queue.insert(3);
        System.out.println(queue.count);
        System.out.println(queue.delMax());
        System.out.println(queue.delMax());
    }

    static class MaxPQ<Key extends Comparable<Key>> {
        // 堆是完全二叉树，用数组表示很方便
        private Key[] pq;
        // 当前个数
        private int count = 0;

        public MaxPQ(int cap) {
            // index = 0不用，因为无法用来计算left，right等
            pq = (Key[]) new Comparable[cap + 1];
        }

        public void insert(Key e) {
            count++;
            pq[count] = e;
            swim(count);
        }

        public Key delMax() {
            Key maxEle = pq[1];
            pq[1] = pq[count];
            pq[count] = null;
            // 必须要先count--，再sink，否则sink中会因为count的错误陷入错误的循环
            count--;
            sink(1);
            return maxEle;
        }

        public Key max() {
            return pq[1];
        }

        // 向上
        public void swim(int k) {
            // 如果k的父节点比k小，二者应该调换位置
            // 一直遍历到root节点(k=1)
            while (k > 1 && less(parent(k), k)) {
                exchange(k, parent(k));
                k = parent(k);
            }
        }

        // 向下
        public void sink(int k) {
            // 如果k节点比左右两个节点中的某个小，二者应该调换位置，并且应该和左右中较大的那个调换
            // 一直找到最底层
            while (left(k) <= count) {
                // 暂定左更大
                int bigger = left(k);
                if (right(k) <= count && less(left(k), right(k))) {
                    bigger = right(k);
                }
                if (less(bigger, k)) {
                    break;
                }
                exchange(k, bigger);
                k = bigger;
            }
        }

        /**
         * 交换两个元素在树中的位置
         */
        public void exchange(int a, int b) {
            Key temp = pq[a];
            pq[a] = pq[b];
            pq[b] = temp;
        }

        public boolean less(int a, int b) {
            return pq[a].compareTo(pq[b]) < 0;
        }

        public int parent(int root) {
            return root / 2;
        }

        public int left(int root) {
            return root * 2;
        }

        public int right(int root) {
            return root * 2 + 1;
        }
    }
}
