package leetcode;
import java.util.*;
public class RecentCounter933 {
	
	public static Queue<Integer> queue;
	//	返回从3000ms前到现在的ping数
	public RecentCounter933() {
        queue = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        int flag = t-3000;
        while(!queue.isEmpty()&&queue.peek()<t-3000) {
        	queue.poll();
        }
        return queue.size();
    }

}
