package daily;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class BlackBoxTest {



    public static void main(final String[] args) {

        final Scanner input = new Scanner(System.in);
        int b, c;
        while(true){
            b = boundaryInput(input, "下界");
            c = boundaryInput(input, "上界");
            if(boundaryChecking(b, c)){
                break;
            } else {
                System.out.println("区间下界" + b + "大于" + "区间上界" + c + "请重新输入");
            }
        }

        int a = boundaryInput(input, "中值");

        if(boundaryChecking(a, b) || boundaryChecking(c, a)){
            System.out.println(a + "您输入数值" + a + "不位于区间[" + b + "," + c + "]内，无效！");
            System.out.println("----------------------------------");
        } else {
            System.out.println("您输入数值" + a + "位于区间[" + b + "," + c + "]内，有效！数值为：" + a);
            System.out.println("----------------------------------");
        }

        System.out.println("区间划分为(" + Integer.MIN_VALUE + "," + b + ")和[" + b + "," + c + "]" + "和(" + c + "," + Integer.MAX_VALUE + ")三部分");
        System.out.println("无效区间为(" + Integer.MIN_VALUE + "," + b + ")和(" + c + "," + Integer.MAX_VALUE + ")两部分");
        System.out.println("有效区间为[" + b + "," + c + "]");
        System.out.println("----------------------------------");

        int d;
        while(true){
            System.out.println("生成随机数数目：");
            d = input.nextInt();
            System.out.println("随机生成的数值为：" + d + "个");
            if (d <= (c-b+1)) {
                System.out.println("数值有效，满足区间绝对值");
                System.out.println("----------------------------------");
                break;
            } else {
                System.out.println("数值无效，请重新输入");
                System.out.println("----------------------------------");
            }
        }

        final Set<Integer> set = randomGenerate(d, b, c);
        randomPrint(set, b, c);

        final Set<Integer> set2 = randomGenerate(d, c, Integer.MAX_VALUE);
        randomPrint(set2, c, Integer.MAX_VALUE);

        final Set<Integer> set3 = new HashSet<>();
        for(int t = 0; t < d; t++) {
            final int y = (int) (Math.random() * (Integer.MAX_VALUE)%(Integer.MAX_VALUE-Math.abs(b)+1) + Math.abs(b));
            final int v = Math.negateExact(y);
            set3.add(v);
        }
        randomPrint(set3, Integer.MIN_VALUE, b);
    }

    private static int boundaryInput(Scanner input, String flag){
        int b = 0;
        while (true) {
            try {
                System.out.println("请输入待划分区间"+flag+"：");
                b = input.nextInt();
                System.out.println("区间"+flag+"：" + b);
                System.out.println("----------------------------------");
                return b;
            } catch (final Exception e) {  //这里用Exception来捕获这个异常
                e.printStackTrace();
                System.out.println("当前输入的区间"+ flag + "不是整数，请重新输入一个整数");
                System.out.println("----------------------------------");
                input.next();  //继续输入
            }
        }
    }

    private static boolean boundaryChecking(int b, int c){
        if (b > c) {
            return false;
        }
        return true;
    }

    private static Set<Integer> randomGenerate(int d, int left, int right){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < d; ) {
            final int x = (int) (Math.random() * (right)%(right-left+1) + left);
            if(set.add(x)){
                i++;
            }
        }
        return set;
    }


    private static void randomPrint(Set<Integer> set, int left, int right){
        int i=1;
        for (final Iterator iter = set.iterator(); iter.hasNext(); i++) {
            final Integer value = (Integer) iter.next();
            System.out.println("在区间("+left+","+right+")内,随机生成的第"+i+"个数的值分别为：" +value);
        }
        System.out.println("----------------------------------");
    }

}