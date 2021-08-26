package leetcodegrindingguide.chapter3;

public class No633judgeSquareNum {

    public boolean judgeSquareNum(int c) {
        int end = (int)Math.sqrt((double)c);
        int start = 0;
        while (start <= end) {
            int cur = start * start + end * end;
            if (cur == c) {
                return true;
            }
            if (cur < c) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
