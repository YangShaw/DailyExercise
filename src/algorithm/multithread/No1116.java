package algorithm.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author YangShaw
 * @date 2021/4/17 11:54
 */
public class No1116 {
    class ZeroEvenOdd {
        private int n;
        private Lock lock = new ReentrantLock();
        private Condition cond1 = lock.newCondition();
        private Condition cond2 = lock.newCondition();
        private Condition cond3 = lock.newCondition();
        private int count = 1;
        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (count <= n) {
                lock.lock();
                while (count != 1) {
                    cond1.await();
                }
                printNumber.accept(0);
                if (count % 2 == 1) {
                    cond2.signal();
                } else {
                    cond3.signal();
                }
                lock.unlock();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (count <= n) {
                lock.lock();
                cond2.await();
                printNumber.accept(count);
                count++;
                cond1.signal();
                lock.unlock();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (count <= n) {
                lock.lock();
                cond3.await();
                printNumber.accept(count);
                count++;
                cond1.signal();
                lock.unlock();
            }
        }
    }
}
