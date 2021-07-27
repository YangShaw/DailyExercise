package interview713;

public class Problem5 {

    public int solution(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return solution(n-1)+solution(n-2);
    }
}
