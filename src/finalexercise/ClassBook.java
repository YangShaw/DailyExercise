package finalexercise;

public class ClassBook {

    public static void main(String[] args) {
        int i=1;
        while(i<10){
            //  先算i%2，然后i++
            if((i++) % 2 ==0 ){
                System.out.println(i);
            }
        }
    }
}
