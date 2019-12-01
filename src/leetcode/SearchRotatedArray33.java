package leetcode;

public class SearchRotatedArray33 {

    //  我自己写的方法也太蠢了
    public int search2(int[] nums, int target){
        int length = nums.length;
        if(length==0){
            return -1;
        }

        int left = 0;
        int right = length-1;

        while(left<right){
            int mid = (right+left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //  判断左边和右边哪边有序
            //  先看左边 这里要写mid而不能写mid-1
            if(nums[left]<nums[mid]){
                //  有序
                if(target>=nums[left] && target<=nums[mid-1]){
                    //  在左边
                    right = mid-1;
                } else {
                    //  在右边
                    left = mid+1;
                }
            } else {
                //  若左边无序则右边一定有序
                if(target>=nums[mid+1] && target<=nums[right]){
                    //  在右边
                    left = mid+1;
                } else {
                    //  在左边
                    right = mid-1;
                }
            }
        }
        if(nums[left]==target){
            return left;
        }
        return -1;
    }


    //  要求复杂度是o logn
    public int search(int[] nums, int target){

        int n = nums.length;
        int mid = n/2;
        while(true){
            if(nums[mid]==target){
                return mid;
            }

            // 判断左边
            if(isSorted(nums, 0,mid-1)){

            }

            // 判断右边

        }
    }

    private boolean isSorted(int[] nums, int start, int end){
        if(nums[start]<=nums[end]){
            return true;
        }
        return false;
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        if(start==end){
            if(nums[start]==target){
                return start;
            }
            return -1;
        }
        int mid = (end+start)/2;
        if(mid==target){
            return mid;
        }
        int left = binarySearch(nums, start, mid-1, target);
        int right = binarySearch(nums, mid+1, end, target);
        if(left!=-1){
            return left;
        } else if(right!=-1){
            return right;
        } else {
            return -1;
        }

    }
}
