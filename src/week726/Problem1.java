package week726;

public class Problem1 {

    public String restoringString(String s, int[] indices) {

        int l = indices.length;
        char[] result = new char[l];
        for (int i = 0; i < l; ++i) {
            result[indices[i]] = s.charAt(i);
        }
        return String.valueOf(result);
    }
}
