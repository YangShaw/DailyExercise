package daily;

public class Exercise {

    public static void main(String[] args) {

        int a =5;
        //int -> integer 整数
        int b = 4;

        int sum = 0;
        for(int i=1; i<101; i=i+1){
            sum = sum+i;
            System.out.println("当前增加的值是"+i+", 当前的和是"+sum);
        }

        System.out.println("最终的计算结果为:");
        System.out.println(sum);



        //System.out.println("a+b");
    }
}
