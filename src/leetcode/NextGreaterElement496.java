package leetcode;
import java.util.*;
public class NextGreaterElement496 {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		//	利用哈希表记录nums2数组中每个元素所在的位置。双层遍历。
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[nums1.length];
		for(int i=0;i<nums2.length;++i) {
			map.put(nums2[i], i);
		}
		
		for(int i=0;i<nums1.length;++i) {
			//	找到该元素在nums2数组中的位置
			int position = map.get(nums1[i]);
			int j = 0;
			for(j=position+1;j<nums2.length;++j) {
				if(nums2[j]>nums1[i]) {
					result[i] = nums2[j];
					break;
				}
			}
			if(j==nums2.length) {
				result[i] = -1;
			}
		}
		return result;
	}
	
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=nums2.length-1;i>=0;--i) {
			//	倒序入栈
			while(!stack.empty()&&stack.peek()<=nums2[i]) {
				//	如果后面的数字（先入栈的数字）比现在的数字小，那么可以抛弃了
				//	因为再往前的数字向后找大数的时候，会被这个大的拦住，不可能看得到后面的小数了
				stack.pop();
			}
			if(stack.empty()) {
				map.put(nums2[i], -1);
			} else {
				map.put(nums2[i], stack.peek());
			}
			stack.push(nums2[i]);
		}
		
		int i=0;
		for(int num : nums1) {
			result[i++] = map.get(num);
		}
		return result;
	}
	
}
