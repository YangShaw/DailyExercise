package javaexercise;

import java.util.Scanner;

public class exercise_08_05 {
	
	static final int ROW = 3;
	static final int COLUMN = 3;
	
	public static double[][] addMatrix(double[][] a, double[][] b){
		double[][] result = new double[ROW][COLUMN];
		for(int i=0;i<ROW;++i) {
			for(int j=0;j<COLUMN;++j) {
				result[i][j] = a[i][j]+b[i][j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		double[][] m1 = new double[ROW][COLUMN];
		double[][] m2 = new double[ROW][COLUMN];
		
		System.out.println("Enter matrix1("+ROW+"*"+COLUMN+"):");
		for(int i=0;i<ROW;++i) {
			for(int j=0;j<COLUMN;++j) {
				m1[i][j] = s.nextDouble();
			}
		}
		System.out.println("Enter matrix2("+ROW+"*"+COLUMN+"):");
		for(int i=0;i<ROW;++i) {
			for(int j=0;j<COLUMN;++j) {
				m2[i][j] = s.nextDouble();
			}
		}
		
		double[][] result = addMatrix(m1, m2);
		System.out.println("The matrices are added as follows");
		for(int r=0;r<ROW;++r) {
			StringBuilder sb = new StringBuilder("");
			for(int c=0;c<COLUMN;++c) {
				sb.append(m1[r][c]+" ");
			}
			if(r==1) {
				sb.append("+\t");
			} else {
				sb.append(" \t");
			}
			for(int c=0;c<COLUMN;++c) {
				sb.append(m2[r][c]+" ");
			}
			if(r==1) {
				sb.append("=\t");
			} else {
				sb.append(" \t");
			}
			for(int c=0;c<COLUMN;++c) {
				sb.append(result[r][c]+" ");
			}
			System.out.println(sb.toString());
		}
	}

}
