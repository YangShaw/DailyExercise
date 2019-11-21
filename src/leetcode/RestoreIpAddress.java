package leetcode;

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddress {

    public static boolean isLegal(String num){
        if("0".equals(num)){
            return true;
        }
        if(num.startsWith("0")){
            return false;
        }
        int a = Integer.parseInt(num);
        if(a>255){
            return false;
        } return true;
    }

    public List<String> restoreIpAddresses(String input){

        int length = input.length();
        List<String> result = new LinkedList<String>();
        if(length>12){
            return result;
        }
        int space = length-1;
        int count=0;
        int il = space-2;
        int jl = space-1;

        for(int i=1;i<=il;++i){
            if(i>3){
                return result;
            }
            for(int j=i+1;j<=jl;++j){
                if(j-i>3){
                    break;
                }
                for(int k=j+1;k<=space;++k){
                    if(k-j>3){
                        break;
                    }
                    if(isLegal(input.substring(k))&&
                            isLegal(input.substring(i,j))&&
                            isLegal(input.substring(j,k))&&isLegal(input.substring(0,i))){
                        result.add(input.substring(0,i)+"."
                                +input.substring(i,j)+"."
                                +input.substring(j,k)+"."
                                +input.substring(k));
                    }
                }
            }
        }

        return result;
    }
}
