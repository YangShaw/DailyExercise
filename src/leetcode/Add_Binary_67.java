package leetcode;

public class Add_Binary_67 {


    public static String solution(String a, String b) {
        int na = a.length() - 1;
        int nb = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (na >= 0 || nb >= 0) {
            int n1 = na >= 0 ? a.charAt(na)-'0' : 0;
            int n2 = nb >= 0 ? b.charAt(nb)-'0' : 0;
            na--;
            nb--;
            int sum = n1+n2+carry;
            sb.append(sum%2);
            carry = sum/2;
        }
        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "100";
        String b = "1";
        System.out.println(solution(a, b));
    }
}
