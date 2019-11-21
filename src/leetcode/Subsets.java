package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        //  空集
        result.add(new LinkedList<>());
        int n = nums.length;

        for(int i=0;i<n;++i){
            int all = result.size();
            for(int j=0;j<all;++j){
                //  遍历result中已经有的所有的元素（每个元素都是一个集合），对每一个元素都增添当前i元素，来形成新的集合
                List<Integer> temp = new LinkedList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }


        return result;
    }
}
