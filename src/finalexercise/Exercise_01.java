package finalexercise;

import java.util.Scanner;

public class Exercise_01 {

    //  ip地址的复原

    public static boolean isLegal(String str){
        if("0".equals(str)){
            return true;
        }
        if(str.startsWith("0")){
            return false;
        }

        int num = Integer.parseInt(str);
        if(num>255){
            return false;
        } return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        int length = input.length();
        if(length>12){
            System.out.println(0);
            return;
        }
        int il = length-3;
        int jl = length-2;
        int kl = length-1;

        int count=0;
        for(int i=1;i<il;++i){
            if(i>3){
                System.out.println(count);
                return;
            }
            for(int j=i+1;j<jl;++j){
                if(j-i>3){
                    break;
                }
                for(int k=j+1;k<kl;++k){
                    if(k-j>3){
                        break;
                    }
                    if(isLegal(input.substring(0, i)) &&
                    isLegal(input.substring(i, j)) &&
                    isLegal(input.substring(j, k)) &&
                    isLegal(input.substring(k))){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);


    }
}
