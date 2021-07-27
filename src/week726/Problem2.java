package week726;

public class Problem2 {

    public int minFlips(String target){
        int i=0;
        int l0 = target.length();
        while(i<l0 && target.charAt(i)=='0'){
            i++;
        }
        target = target.substring(i);
        int l = target.length();
        if(l==0){
            return 0;
        }

        int result = 1;
        char pre = target.charAt(0);
        for(int j=1; j<l; ++j){
            if(target.charAt(j)!=pre){
                pre = target.charAt(j);
                result++;
            }
        }
        return result;
    }
}
