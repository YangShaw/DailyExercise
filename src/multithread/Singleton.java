package multithread;

public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton(){

    }

    public synchronized static Singleton getUniqueInstance(){
        if(uniqueInstance==null){

            synchronized (Singleton.class){
                if(uniqueInstance==null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
