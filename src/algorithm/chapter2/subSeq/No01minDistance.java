package algorithm.chapter2.subSeq;

/**
 * @author YangShaw
 * @date 2021/4/11 9:03
 */
public class No01minDistance {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1][l2];

        int[] nums = new int[4];
        // base case
        return 0;
    }

    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
