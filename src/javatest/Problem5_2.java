package javatest;

import java.util.Scanner;
import java.util.Stack;

public class Problem5_2 {
    public static void main(String[] args) {

        //	��ȡ����
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = s.nextInt();
        }

        //	��ʼ��һ��ջ�����ڵ���洢����Ԫ��
        Stack<Integer> stack = new Stack<Integer>();
        //	�Ȱ�����ĩλԪ��ѹ��ջ�У�����һ��ѭ��
        stack.push(nums[n - 1]);
        //	��min���������湹��2Ԫ���еĳ�ջԪ���е���Сֵ��
        int min = 0;
        //	��һ��������������¼�Ƿ��з���������2Ԫ����
        boolean flag = false;

        //	�����������
        for (int i = n - 2; i >= 0; --i) {
            //	���Ƶ���ջ��˼�룬���ջ��Ԫ�ش��ڲ���С�ڵ�ǰԪ�أ���Ҫ������ջ
            //	����while��һֱ�ҵ�ջ��Ԫ�رȵ�ǰԪ�ش�Ϊֹ
            while (!stack.empty() && nums[i] >= stack.peek()) {
                //	Ϊ�˷�ֹ�Ѿ�������Ч��3Ԫ���е�Ԫ�ر������޷���⣬���Գ�ջǰ�Ƚ����жϡ�
                //	��Ϊ��ջ�������Ѿ�ȷ����ջ��Ԫ���Ե������ǵݼ��ģ��������ջ���Ѿ����˲�����3��Ԫ�أ�
                //	��ô��3��Ԫ���������о͹����˵���3Ԫ�����У�����ֱ���ж�Ϊtrue
                if (stack.size() >= 3) {
                    System.out.println("true");
                    return;
                }
                //	���ջ����2��Ԫ�ع����������У���ôҲҪ�����Ǳ�����������Ϊǰ����ܴ���һ����С��Ԫ��
                //	���Ժ���2��Ԫ�ع���3Ԫ���С����ֱ��ɾ������¼һ�£��ͻ���Ե����������
                //	����8 3 9 6 7����������
                if (stack.size() == 2) {
                    //	ֻ��2��Ԫ�ص������Ҫ�����жϣ�����ֻ�����С����һ��(ջ����)Ԫ�ؾͿ��ԡ���С�Ĵ���min������
                    int temp = stack.peek();
                    if (!flag) {
                        flag = true;
                        min = temp;
                    } else {
                        if (temp < min) {
                            min = temp;
                        }
                    }

                }
                //	ջ��Ԫ�س�ջ
                stack.pop();
            }
            //	�ж�һ�µ�ǰԪ���ܷ��ǰ����ڵ�2Ԫ�������3Ԫ����
            if (nums[i] < min) {
                System.out.println("true");
                return;
            }
            //	��ǰԪ����ջ
            stack.push(nums[i]);
        }

        System.out.println("false");
    }
}
