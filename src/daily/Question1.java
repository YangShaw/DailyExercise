package daily;

import java.util.Scanner;

public class Question1 {
    //3 5 -8 6 -3 4 -5 9
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = s.nextInt();
        }

        int neg = -1;    //	������λ��
        int sum = 0;
        int start = 0;
        int negsum = 0;
        for (int i = 0; i < n; ++i) {
            if (array[i] > 0) {
                if (neg == -1) {
                    // 	�������Ҫ���Ǹ�������ôֱ�Ӽ�
                    sum += array[i];
                } else {
                    //	�����Ҫ���Ǹ���
                    negsum += array[i];
                    if (negsum >= 0) {
                        neg = -1;
                        sum = sum + negsum;
//						System.out.println("����"+sum);
                        negsum = 0;
                    }
                }
            } else {
                neg = i;
                negsum += array[i];
                if (negsum + sum <= 0) {
                    //	ֱ������ǰ�����е�
                    sum = 0;
                    //	����һλ��ʼ����
                    start = i + 1;
                    neg = -1;
                    negsum = 0;
                } else if (negsum >= 0) {
                    neg = -1;
                    sum = sum + negsum;
                }
            }
        }
        System.out.println(sum);
    }
}
