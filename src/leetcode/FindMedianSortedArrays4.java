package leetcode;

public class FindMedianSortedArrays4 {
	
	public static double computeMedian(int[] nums) {
		int l = nums.length;
		int mid = l/2;
    	if(l%2==1) {
    		return nums[mid];
    	} else {
    		return (nums[mid-1]+nums[mid])/2.0;
    	}
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = m+n;
        int mid = l/2;	//	奇数的情况下的中位数，偶数时候要找这个元素和它前面的元素
        System.out.println(mid);
        
        int[] nums = new int[l];
        int i=0,j=0;	//	表示两个数组中目前检索到的位置
        int cur = 0;	//	表示当前读取到的位数
        while(i<m&&j<n) {
        	//	还在从两个数组中比较当前元素
        	nums[cur] = nums1[i]<nums2[j] ? nums1[i++] : nums2[j++];
        	if(cur==mid) {
        		//	直接结束就好了
        		return computeMedian(nums);
        	} else {
        		cur++;
        	}
        }
        System.out.println("cur = " + cur);
        //	在前面的循环中就已经解决了问题
        

        //	如果有某个数组已经到头了，再数另一个数组
        if(i==m) {
        	//	数nums2数组
        	while(true) {
        		nums[cur]=nums2[j++];
        		if(cur==mid) {
        			return computeMedian(nums);
        		}
        		cur++;
        	}
        } else {
        	while(true) {
        		nums[cur]=nums1[i++];
        		if(cur==mid) {
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
		int[] nums1 = {1,2};
		int[] nums2 = {1,2,5,7,9,10,11};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
