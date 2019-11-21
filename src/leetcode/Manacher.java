package leetcode;

public class Manacher {
	
	public static String Manacher(String input) {

//		增加辅助字符，使奇偶一致
		String t = "^#";
		char[] inputc = input.toCharArray();
		for(int i=0;i<inputc.length;++i) {
			t = t+inputc[i];
			t = t+"#";
		}
		t = t+'$';
		System.out.println(t);
		char[] tc = t.toCharArray();
		
		for(int i=0;i<tc.length;++i) {
			
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		String input = "noon";
		Manacher(input);
	}

}
