package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exist79 {

    class Tuple{
        int a;
        int b;
        public Tuple(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static int rl;
    public static int cl;
    public static boolean flag;
    public boolean exist(char[][] board, String word){
        if(board.length==0){
            return false;
        }
        rl = board.length;
        cl = board[0].length;
        List<Tuple> origin = new ArrayList<>();
        flag = false;

        //  先找到起点
        char start = word.charAt(0);
        for(int i=0; i<rl; ++i){
            for(int j=0; j<cl; ++j){
                if(board[i][j] == start){
                    origin.add(new Tuple(i, j));
                }
            }
        }

        if(origin.isEmpty()){
            return false;
        }

        Stack<Tuple> stack = new Stack<>();
        while(!origin.isEmpty()){
            stack.push(origin.remove(0));
            while(!stack.isEmpty()){
                //  开始DFS遍历
                Tuple current = stack.pop();
                int i = current.a;
                int j = current.b;
                //  to right
                dfs(i, j+1, 0, 1, board, word);
                if(flag){
                    return true;
                }
                //  to bottom
                dfs(i+1, j, 1, 1, board, word);
                if(flag){
                    return true;
                }
                //  to left
                dfs(i, j-1, 2, 1, board, word);
                if(flag){
                    return true;
                }
                //  to top
                dfs(i-1, j, 3, 1, board, word);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    direction:
    0   from left
    1   from top
    2   from right
    3   from bottom
     */
    public void dfs(int row, int column, int direction, int index, char[][] words, String word){
        if(row<0 || row>rl || column<0 || column>cl){
            return;
        }
        if(word.charAt(index)==words[row][column]){

        } else {

        }

    }

}
