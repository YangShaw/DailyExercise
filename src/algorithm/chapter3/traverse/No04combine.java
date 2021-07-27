package algorithm.chapter3.traverse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangShaw
 * @date 2021/4/9 18:15
 */
public class No04combine {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(1, n, k, new ArrayList<>());
        return result;
    }

    public void backTrack(int start,int n, int k, List<Integer> track) {
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(i + 1, n, k, track);
            track.remove(track.size() - 1);
        }
    }
}
