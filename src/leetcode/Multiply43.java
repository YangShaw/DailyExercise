package leetcode;

public class Multiply43 {


    //  直接参考评论的题解，自己实现一遍
    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if (n1 < 0 || n2 < 0) {
            return "0";
        }
        //  乘积的位数至多是两个乘数位数之和
        int[] result = new int[n1 + n2 + 2];

        //  乘数
        for (int i = n1; i >= 0; --i) {
            //  被乘数
            for (int j = n2; j >= 0; --j) {
                //  当前两位的乘积
                //  这种通过-'0'来将char数字转换成int的方法也常用到了
                int temp = (int) (num1.charAt(i) - '0') * (int) (num2.charAt(j) - '0');

                //  **易错处
                //  先和上一轮的进位相加，以判断是否会产生新的进位
                temp = temp + result[i + j + 1];
                //  当前位
                result[i + j + 1] = temp % 10;
                //  产生的进位
                result[i + j] = result[i + j] + temp / 10;
            }
        }

        int k = 0;
        while (k < result.length - 1 && result[k] == 0) {
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for (; k < result.length; ++k) {
            sb.append(result[k]);
        }
        return sb.toString();

    }
}
