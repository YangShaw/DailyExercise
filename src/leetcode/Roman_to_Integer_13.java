package leetcode;

import java.util.*;

public class Roman_to_Integer_13 {
    public static int toNumber(char a) {
        switch (a) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static int romanToInt(String s) {


        char array[] = s.toCharArray();
        int result = 0;
        int temp = toNumber(array[0]);
        int value = 0;
        for (int i = 1; i < array.length; i++) {
            value = toNumber(array[i]);
            if (value > temp) {
                result += (-1 * temp);
            } else {
                result += temp;
            }
            temp = value;
        }
        result += temp;


        return result;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char array[] = s.toCharArray();
        int result = 0;
        int temp = (int) map.get(array[0]);
        int value = 0;
        for (int i = 1; i < array.length; i++) {
            value = (int) map.get(array[i]);
            if (value > temp) {
                result += (-1 * temp);
            } else {
                result += temp;
            }
            temp = value;
        }
        result += temp;


        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(romanToInt2("MCMXCIV"));
    }

}
