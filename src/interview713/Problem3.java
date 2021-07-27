package interview713;

public class Problem3 {

    public int findLongestAscending(int[] array, int n){
        if(n==1 || n==0){
            return 0;
        }
        int cur = array[0];
        int max = -1;
        int index = 0;
        int result = 0;
        for(int i=1;i<n;++i){
            if(array[i]<array[i-1]){
                int length = i-index;
                if(max<length){
                    max = length;
                    result = index;
                }
                index = i;
            }
        }
        int length = n-1-index;
        if(max<length){
            max = length;
            result = index;
        }
        return result;
    }
}
