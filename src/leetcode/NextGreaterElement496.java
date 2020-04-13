package leetcode;

import java.util.*;

public class NextGreaterElement496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //	���ù�ϣ���¼nums2������ÿ��Ԫ�����ڵ�λ�á�˫�������
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; ++i) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; ++i) {
            //	�ҵ���Ԫ����nums2�����е�λ��
            int position = map.get(nums1[i]);
            int j = 0;
            for (j = position + 1; j < nums2.length; ++j) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) {
                result[i] = -1;
            }
        }
        return result;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = nums2.length - 1; i >= 0; --i) {
            //	������ջ
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                //	�����������֣�����ջ�����֣������ڵ�����С����ô����������
                //	��Ϊ����ǰ����������Ҵ�����ʱ�򣬻ᱻ��������ס�������ܿ��õ������С����
                stack.pop();
            }
            if (stack.empty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        int i = 0;
        for (int num : nums1) {
            result[i++] = map.get(num);
        }
        return result;
    }

}
