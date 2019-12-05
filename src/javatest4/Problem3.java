package javatest4;
import java.util.Scanner;
public class Problem3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        int l1 = a.length()-1;
        int l2 = b.length()-1;

        //  确保a是最大的，b是最小的；和补零的方法二者选其一就可以。
        if(l1<l2){
            String temp = b;
            b = a;
            a = temp;
            l1 = a.length()-1;
            l2 = b.length()-1;
        }

        int dis = l1-l2;
        StringBuilder stringBuilder = new StringBuilder();
        //  将较短的数字通过补零的方式来使二者对齐
        for(int i=0;i<dis;++i){
            stringBuilder.append(0);
        }
        b = stringBuilder.toString()+""+b;

        int[] result = new int[l1+1];
        int carry = 0;
        while(l1>=0){
            //  通过-'0'的方式将字符型的数字转化成整数型
            int add1 = a.charAt(l1)-'0';
            int add2 = b.charAt(l1)-'0';
            int temp = add1+add2+carry;
            //  获取进位
            carry = temp / 10;
            //  当前位的值
            temp = temp % 10;
            result[l1] = temp;
            l1--;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        //  总位数+1的情况
        if(carry!=0){
            stringBuilder2.append(1);
        }
        int rn = result.length;

        //  将整数数组转化成字符串
        for(int i=0;i<rn;++i){
            stringBuilder2.append(result[i]);
        }
        System.out.println(stringBuilder2.toString());
    }
}
