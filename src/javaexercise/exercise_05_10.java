package javaexercise;

import java.util.*;

public class exercise_05_10 {

    static final int START = 10;
    static final int END = 1000;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int firstNum = 0;
        for (int i = START; i <= END; ++i) {
            if (i % 5 == 0 && i % 6 == 0) {
                firstNum = i;
                break;
            }
        }
        int temp = 0;
        while (firstNum <= END) {
            System.out.print(firstNum + "\t");
            temp++;
            firstNum += 30;
            if (temp == 10) {
                System.out.println();
                temp = 0;
            }
        }


    }

}
