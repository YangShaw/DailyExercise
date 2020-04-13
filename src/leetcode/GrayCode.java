package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>((int) Math.pow(2, n));
        result.add(0);
        //  第一次需要在前面添加的部分是1，后面依次变成10，100，通过移位操作来实现；
        //  需要在前面添加0的那些数和上一次计算的结果完全相同，不需要考虑。
        int head = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = result.size() - 1; j >= 0; --j) {
                result.add(head + result.get(j));
            }
            //  左移一位的操作
            head = head << 1;
        }
        return result;
    }
}
