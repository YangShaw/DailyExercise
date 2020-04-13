package daily;

public class ThreadTest {

    public static void main(String[] args) {

        new ThreadTest().shareMethod();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                new ThreadTest().shareMethod();
            }

        }, "t1").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                new ThreadTest().shareMethod();
            }
//			
        }, "t2").start();
    }

    public void shareMethod() {
        Thread thread = Thread.currentThread();
        System.out.println("current:" + thread.getName());
    }
}
