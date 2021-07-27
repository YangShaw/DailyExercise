package interview718Huawei;

import java.util.Stack;

public class Problem {

    public static String solution(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int len = s.length();
        boolean single = false;

        for(int i=0;i<len;++i){
            //判断是否是k=1的情况（省略不写）
            if(stack.isEmpty()&&!Character.isDigit(s.charAt(i))){
                single = true;
            }
            //判断k=1的情况是否结束
            if(single && Character.isDigit(s.charAt(i))){
                StringBuilder cur = new StringBuilder();
                while(!stack.isEmpty()){
                    cur.append(stack.pop());
                }
                result.append(cur.reverse());
                single = false;
                stack.push(s.charAt(i));
                continue;
            }
            //正常压栈
            if(s.charAt(i)!=']'){
                stack.push(s.charAt(i));
            } else {
                StringBuilder cur = new StringBuilder();
                while(stack.peek()!='['){
                    cur.append(stack.pop());
                }
                stack.pop();
                int count = stack.pop()-'0';
                cur = cur.reverse();
                //判断是否是嵌入的情况
                if(!stack.isEmpty()){
                    //栈不为空说明有嵌入，将当前的字符串count后压回到栈中
                    for(int j=0;j<count;++j){
                        int curL = cur.length();
                        for(int k=0;k<curL;++k){
                            stack.push(cur.charAt(k));
                        }
                    }
                } else {
                    //栈为空说明当前的字符串count后直接输出到result中即可
                    for(int j=0;j<count;++j){
                        result.append(cur);
                    }
                }
            }
        }
        StringBuilder cur = new StringBuilder();
        //如果最后一组字符串也是k=1的情况，那么不会遇到]，也就不会自动输出出来，需要进行一轮判断
        while(!stack.isEmpty()){
            cur.append(stack.pop());
        }
        result.append(cur.reverse());

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c2[b]]]";
        System.out.println(solution(s));
    }
}
