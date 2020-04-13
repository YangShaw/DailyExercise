package javaexercise;

import java.util.*;

public class exercise_07_07 {

    static final int COUNT = 100;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] counts = new int[10];
        for (int i = 0; i < COUNT; ++i) {
            int temp = (int) (Math.random() * 10);
            counts[temp]++;
        }
        System.out.println("��ֵ\t���ִ���");
        for (int i = 0; i < 10; ++i) {
            System.out.println(i + "\t" + counts[i]);
        }
    }

}
