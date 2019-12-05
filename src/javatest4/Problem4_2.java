package javatest4;

import java.util.*;

public class Problem4_2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] list = new int[n];
        int[] sorted = new int[n];
        for(int i=0;i<n;++i){
            int temp = s.nextInt();
            list[i] = temp;
            sorted[i] = temp;
        }
        Arrays.sort(sorted);
        int min=n-1, max=0;
        for(int i=0;i<n;++i){
            //  逐个比对数字
            if(list[i]!=sorted[i]){
                min = i;
                break;
            }
        }
        if(min==n-1){
            //  原本就有序
            System.out.println(0);
            return;
        }
        for(int i=n-1;i>min;--i){
            if(list[i]!=sorted[i]){
                max = i;
                break;
            }
        }
        System.out.println(max-min+1);
    }
}
