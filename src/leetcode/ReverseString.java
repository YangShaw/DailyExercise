package leetcode;

public class ReverseString {

    //  注意一下临界问题
    //  奇数，中间那个不会被遍历到
    //  偶数，中间两个也会被交换
    public void reverseString(char[] s){
        int length = s.length;
        int maxIndex = length-1;
        for(int i=0;i<length/2;++i){
            char temp = s[i];
            s[i] = s[maxIndex-i];
            s[maxIndex-i] = temp;
        }
    }

    //  这种方法不会改变数组中的值
    public void swap(char a, char b){
        char temp = a;
        a = b;
        b = temp;
    }
}
