package interview0411meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YangShaw
 * @date 2021/4/11 9:55
 */
public class Problem2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // 对手
        int n = s.nextInt();
        // 我方
        int m = s.nextInt();
        int[] nd = new int[n];
        int[] md = new int[m];
        for (int i = 0; i < n; i++) {
            nd[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            md[i] = s.nextInt();
        }
        Arrays.sort(nd);
        Arrays.sort(md);
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nd[i] == nd[i-1]){
                continue;
            }
            int d = nd[i];
            int nscore = 2 * (n-i-1) + i+1;
            for (; j < m; j++) {
                if (md[j] > d) {
                    break;
                }
            }
            int mscore = 2 * (m-j) + j;
            max = Math.max(max, mscore-nscore);
            
        }
        int k = 0;
        for (int i = 0; i <m; i++) {
            int d = md[i];
            int mscore = 2*(n-i-1) + i + 1;
            for(; k <n; k++) {
                if (nd[k] >d) {
                    break;
                }
            }
            int nscore = 2*(n-k) + k;
            max = Math.max(max, mscore-nscore);
        }
        System.out.println(max);
    }
}
