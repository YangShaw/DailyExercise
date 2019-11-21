package leetcode;
import java.util.*;
public class SimplifyPath71 {

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] array = path.split("/");
		StringBuilder result = new StringBuilder("");
		for(String s : array) {
			if(s.equals(".")||s.equals("")) {
				//	表示当前目录，不需要处理
				continue;
			} else if(s.equals("..")) {
				//	表示跳转上一级目录，那么取消上一级的跳转。但如果就在根目录下，则不用跳转
				if(!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}
		if(stack.empty()) {
			//	如果结果是根目录，那么需要增加一个/来表示之
			result.append("/");
		} else {
			for(String s : stack) {
				result.append("/");
				result.append(s);
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String path = "/a//b////c/d//././/..";
		System.out.println(simplifyPath(path));
	}
}
