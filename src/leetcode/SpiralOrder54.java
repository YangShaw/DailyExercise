package leetcode;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder54 {
	
	boolean hasFinished(int start, int end) {
		cur = cur+end-start;
		if(cur==count) {
			return true;
		}
		return false;
	}
	
	static int cur;
	static int count;
	public List<Integer> spiralOrder(int[][] matrix) {
        
		List<Integer> result = new LinkedList<>(); 
		
		int m = matrix.length;
		if(m==0) {
			return result;
		}
		int n = matrix[0].length;
		
		int fromL = 0;	//	�������ҵ����
		int fromU = 1;	//	�������µ����
		int fromR = n-2;	//	������������
		int fromD = m-2;	//	�������ϵ����
		cur = 0;
		count = m*n;
		while(true) {
			for(int i=fromL;i<fromR+2;++i) {
				result.add(matrix[fromU-1][i]);
			}
			if(hasFinished(fromL, fromR+2)) {
				break;
			}
			fromL++;	//	������������һ��֮����һ���������Ųһλ
			
			for(int j=fromU;j<fromD+2;++j) {
				result.add(matrix[j][fromR+1]);
			}
			if(hasFinished(fromU, fromD+2)) {
				break;
			}
			fromU++;
			
			for(int i=fromR;i>fromL-2;--i) {
				result.add(matrix[fromD+1][i]);
			}
			if(hasFinished(fromL-2, fromR)) {
				break;
			}
			fromR--;
			
			for(int j=fromD;j>fromU-2;--j) {
				result.add(matrix[j][fromL-1]);
			}
			if(hasFinished(fromU-2, fromD)) {
				break;
			}
			fromD--;
		}
		
		return result;
        
    }

}
