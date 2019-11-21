package leetcode;

public class Merge_Sorted_Array_88 {
	
	public static void solution(int[] nums1, int m, int[] nums2, int n) {
		int l = m+n-1;
		int one=m-1, two=n-1;	//	标志两个数组当前指针位置，从后往前。
		
		//	从后往前存储，能尽量减少前面的移动
		while(one>=0&&two>=0) {
			if(nums1[one]>nums2[two]) {
				nums1[l]=nums1[one];
				one--;
			} else {
				nums1[l]=nums2[two];
				two--;
			}
			l--;
		}
		
		//	因为时把two并入到one，所以看看two中是否还有剩下的。
		if(two>=0) {
			for(int i=0;i<=two;++i) {
				nums1[i]=nums2[i];
			}
		}
	}

}
