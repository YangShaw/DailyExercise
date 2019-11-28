package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    List<List<Integer>> result;
    int[] candidates;
    public List<List<Integer>> subsetsWithDup(int[] nums){
        result = new ArrayList<>();
        //  先把空集加进去
        result.add(new ArrayList<>());
        candidates = nums;
        Arrays.sort(candidates);
        backTrack();
        return result;

    }

    private void backTrack(){

    }
}
