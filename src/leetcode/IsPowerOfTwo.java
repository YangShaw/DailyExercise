package leetcode;

//  需要考虑负数的情况和0的情况
//  注意这里给定的输入是整数，不需要考虑2的负数次幂
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n){
        if(n<=0){
            return false;
        }

        while(n>1){
            if(n%2!=0){
                return false;
            }
            n = n/2;
        }
        return true;
    }
}
