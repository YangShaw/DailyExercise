package multithread;

public class DeadLockSolveDemo {

    public static Object resource1 = new Object();
    public static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"get res1");
                    try{
                        Thread.sleep(100);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"waiting for res2");
                    synchronized (resource2){
                        System.out.println(Thread.currentThread()+"get res2");
                    }
                }
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"get res1");
                    try{
                        Thread.sleep(100);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"waiting for res2");
                    synchronized (resource2){
                        System.out.println(Thread.currentThread()+"get res2");
                    }
                }
            }
        }, "thread2").start();


    }
}
