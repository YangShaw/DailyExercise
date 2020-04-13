package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {

    public static List<String> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n){
       //   这一句在LeetCode中需要加上。因为它的逻辑貌似是在同一次中连续测试，如果不clear可能
        //  每次的结果都会始终存留在静态数组result中。
        result.clear();

        StringBuilder sb = new StringBuilder("(");
        generate(sb, 1, n);
        return result;
    }

    public static void generate(StringBuilder sb, int left, int right){

        //  递归终止条件
        if(right==1){
            //  只剩下一个右括号，那么只有两种情况
            if(left==0){
                //  如果前面的左括号都已经被消耗掉了，那么再增加一组完整括号
                sb.append("()");
                result.add(sb.toString());
            } else {
                //  如果前面还有剩下的，则直接把这个右括号放过来
                sb.append(")");
                result.add(sb.toString());
            }
            return;
        }

        if(left>0){
            //  两种情况
            if(left<right){
                //  只有右括号比左括号多的情况下，才可以再增加一个左括号
                StringBuilder sbl = new StringBuilder(sb);
                sbl.append("(");
                generate(sbl, left+1, right);
            }
            //  使用一个右括号来消耗一个左括号一定是没问题的
            sb.append(")");
            generate(sb, left-1, right-1);
        } else {
            //  此时没有左括号，只能增加左括号
            sb.append("(");
            generate(sb, left+1, right);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        generateParenthesis(n);
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i));
        }
    }
}
