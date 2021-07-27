package algorithm.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YangShaw
 * @date 2021/4/17 11:26
 */
public class No1114 {

    class Foo {

        private Lock lock = new ReentrantLock();
        private Condition cond1 = lock.newCondition();
        private Condition cond2 = lock.newCondition();
        private Condition cond3 = lock.newCondition();
        private int num;
        public Foo() {
            num = 1;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            while (num != 1) {
                cond1.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num = 2;
            cond2.signal();
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            while (num != 2) {
                cond2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num = 3;
            cond3.signal();
            lock.unlock();
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            while (num != 3) {
                cond3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            num = 1;
            cond1.signal();
            lock.unlock();
        }
    }
}
