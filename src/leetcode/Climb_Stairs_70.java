package leetcode;

public class Climb_Stairs_70 {

    public int[] array;

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        return compute(n);
    }

    public int compute(int n) {
        if (array[n] != 0)
            return array[n];
        else {
            array[n] = compute(n - 1) + compute(n - 2);
            return array[n];
        }
    }

}
