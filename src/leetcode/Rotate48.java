package leetcode;

public class Rotate48 {

    public static void rotate(int[][] matrix){
        int n = matrix.length;
        //  四条边上开始的
        int left = 0, up = 0, right = n-1, down = n-1;
        //  初始，每条边读取的数字个数
        int count = n-1;

        while(count>0){
            //  存储left-right边
            int[] store = new int[count];
            for(int i=0;i<count;++i){
                store[i] = matrix[up][left+i];
            }
            //  left to up
            for(int i=0;i<count;++i){
                matrix[up][left+i] = matrix[down-i][left];
            }
            //  up to right
            for(int i=0;i<count;++i){
                matrix[down-i][left] = matrix[down][right-i];
            }
            //  right to down
            for(int i=0;i<count;++i){
                matrix[down][right-i] = matrix[up+i][right];
            }
            //  up to right
            for(int i=0;i<count;++i){
                matrix[up+i][right] = store[i];
            }
            //  索引修改
            left++;
            up++;
            right--;
            down--;
            //  每一轮迭代后，矩阵内移一层，各条边上读取的个数减一
            count = count-2;
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix.length;++j){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
