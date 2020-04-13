package leetcode;

public class FindMedianSortedArrays4 {

    public static double computeMedian(int[] nums) {
        int l = nums.length;
        int mid = l / 2;
        if (l % 2 == 1) {
            return nums[mid];
        } else {
            return (nums[mid - 1] + nums[mid]) / 2.0;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m + n;
        int mid = l / 2;    //	����������µ���λ����ż��ʱ��Ҫ�����Ԫ�غ���ǰ���Ԫ��
        System.out.println(mid);

        int[] nums = new int[l];
        int i = 0, j = 0;    //	��ʾ����������Ŀǰ��������λ��
        int cur = 0;    //	��ʾ��ǰ��ȡ����λ��
        while (i < m && j < n) {
            //	���ڴ����������бȽϵ�ǰԪ��
            nums[cur] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            if (cur == mid) {
                //	ֱ�ӽ����ͺ���
                return computeMedian(nums);
            } else {
                cur++;
            }
        }
        System.out.println("cur = " + cur);
        //	��ǰ���ѭ���о��Ѿ����������


        //	�����ĳ�������Ѿ���ͷ�ˣ�������һ������
        if (i == m) {
            //	��nums2����
            while (true) {
                nums[cur] = nums2[j++];
                if (cur == mid) {
                    return computeMedian(nums);
                }
                cur++;
            }
        } else {
            while (true) {
                nums[cur] = nums1[i++];
                if (cur == mid) {
                    return computeMedian(nums);
                }
                cur++;
            }
        }

//        if(l%2==1) {
//    		return nums[mid];
//    	} else {
//    		return (nums[mid-1]+nums[mid])/2.0;
//    	}

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 2, 5, 7, 9, 10, 11};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
