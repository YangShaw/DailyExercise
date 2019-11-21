package leetcode;

/*
    几个标*的地方都是容易出错的边界问题
    这种边界不好思考的地方，画图看一看，不要凭空想
 */
public class ReverseStr {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 8;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k){

        char[] array = s.toCharArray();
        int length = array.length;
        int step = 2*k;
        int i;
        for(i=0;(i+step)<length;i=i+step){
            System.out.println(i);
            reverse(i, k, array);
        }
        if(length-i>=k){
            System.out.println("dd+"+i);
            reverse(i, k, array);
        } else {
            // **
            reverse(i, length-i, array);
        }

        return new String(array);
    }

    //  翻转从start开始的k个字符
    public static void reverse(int start, int k, char[] array){
        // **
        int maxIndex = start+k-1;
        for(int i=start;i<start+k/2;++i){
            System.out.println("swap "+i+"\t"+(maxIndex-i+start));
            char temp = array[i];
            // **
            array[i] = array[maxIndex-i+start];
            array[maxIndex-i+start] = temp;
        }
    }
}
