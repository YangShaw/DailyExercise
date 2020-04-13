package javaexercise;

import java.io.*;
import java.util.*;

public class exercise_12_15 {


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        FileOutputStream fos = new FileOutputStream("d:/iotest/text_12_15.txt");
        PrintWriter writer = new PrintWriter(fos);

        for (int i = 1; i <= 100; ++i) {
            writer.print((int) (1 + Math.random() * 100));
            writer.print(" ");
            //	����
//			if(i%10==0) {
//				writer.println();
//			}
        }

        writer.close();
        fos.close();
        System.out.println("writing completed");

        BufferedReader br = new BufferedReader(new FileReader("d:/iotest/text_12_15.txt"));
        String line = br.readLine();
        br.close();

        String[] array = line.split(" ");
        int[] nums = new int[array.length];
        for (int i = 0; i < 100; ++i) {
            nums[i] = Integer.parseInt(array[i]);
        }
//		System.out.println(array.length);
        Arrays.sort(nums);
        for (int i = 0; i < 100; ++i) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(nums[i] + "\t");
        }

    }

}
