package algorithm.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YangShaw
 * @date 2021/4/17 11:39
 */
public class No1115 {

    class FooBar {
        private int n;
        private Lock lock = new ReentrantLock();
        private Condition cond1 = lock.newCondition();
        private Condition cond2 = lock.newCondition();
        int num;
        public FooBar(int n) {
            this.n = n;
            num = 1;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                while (num != 1)
                    cond1.await();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                num = 2;
                cond1.signal();
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                while (num != 2)
                    cond1.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                num = 1;
                cond1.signal();
                lock.unlock();
            }
        }
    }
}
