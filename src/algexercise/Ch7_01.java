package algexercise;

public class Ch7_01 {

    //  匈牙利算法
    public static boolean[][] edges;

    public static int[] girls;
    public static boolean[] used;

    public static boolean find(int x){
        int count = girls.length;
        for(int i=0;i<count;++i){
            if(edges[x][i]==true && !used[i]){
                used[i] = true;
                if(girls[i]==0 || find(girls[i]-1)){
                    girls[i]=x+1;
                    System.out.println(x+" & "+i);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        edges = new boolean[][]{
                {true, true, false, false},
                {false, true, true, false},
                {true, true, false, false},
                {false, false, true, false}};
        int count = edges.length;
        girls = new int[count];
        for(int i=0;i<count;++i){
            used = new boolean[count];
            if(find(i)){
                System.out.println(i);
            }
        }
    }
}
