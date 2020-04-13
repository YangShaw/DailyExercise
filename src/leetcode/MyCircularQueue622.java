package leetcode;

public class MyCircularQueue622 {

    public static int head;
    public static int tail;
    public static int[] queue;
    public static int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue622(int k) {
        //	����index = 0�����Ա��ڼ���
        queue = new int[k + 1];
        head = 1;
        tail = 1;
        size = 0;

    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % queue.length;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        queue[head] = 0;
        head = (head + 1) % queue.length;
        size--;
        return true;

    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return queue[head];

    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;

    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if (size == queue.length - 1) {
            return true;
        }
        return false;
    }

}
