package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YangShaw
 * @date 2021/4/14 10:01
 */
public class PrintABC {

    private static Lock lock = new ReentrantLock();
    private static Condition condA = lock.newCondition();
    private static Condition condB = lock.newCondition();
    private static Condition condC = lock.newCondition();

    private static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    // 没轮到A的时候，condA一直等待
                    while (count % 3 != 0) {
                        condA.await();
                    }
                    System.out.println("A");
                    count++;
                    condB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    // 没轮到A的时候，condA一直等待
                    while (count % 3 != 1) {
                        condB.await();
                    }
                    System.out.println("B");
                    count++;
                    condC.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    // 没轮到A的时候，condA一直等待
                    while (count % 3 != 2) {
                        condC.await();
                    }
                    System.out.println("C");
                    count++;
                    condA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
