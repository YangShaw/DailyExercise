package leetcode;
import java.util.*;
public class CommonChars1002 {

	public List<String> commonChars(String[] a){
		List<String> result = new ArrayList<String>();
		int[] array = new int[26];	//	�洢 ������ĸ�ж��ٸ�
		
		int count = a.length;
		for(char c : a[0].toCharArray()) {
			array[c-'a']++;	//	ͨ����ȥСд��ĸa��Ϊ��׼ֵ��
		}
		
		for(int i=1;i<count;++i) {
			//	���ַ�������a��ʣ�µ��ַ�������ƥ��
			int[] temp = new int[26];
			
			for(char cc : a[i].toCharArray()) {
				temp[cc-'a']++;
			}
			

			
		}
		
		
		return result;
	}
}
