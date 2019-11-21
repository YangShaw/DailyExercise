package javatest3;

import java.util.Scanner;

public class Problem3 {

    public static boolean isLegal(int starti, int startj, int side, int[][] matrix){
        int l1 = side+starti;
        int l2 = side+startj;
        for(int i=starti;i<l1;i++){
            for(int j=startj;j<l2;j++){
                if(matrix[i][j]==0){
                    //System.out.println("wrong in side "+side+" and [ "+i+"\t"+j+"\t");
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        int[][] matrix = new int[row][col];
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                matrix[i][j] = s.nextInt();
            }
        }
        int side = row<col?row:col;

        for(;side>0;--side){
            //  遍历判断边长从side到1的正方形是否存在
            int end2 = row-side+1;
            int end = col-side+1;
            for(int i=0;i<end2;++i){
                for(int j=0;j<end;++j){
                    if(isLegal(i,j,side,matrix)){
                        //System.out.println(i+"\t"+j);
                        System.out.println(side*side);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
