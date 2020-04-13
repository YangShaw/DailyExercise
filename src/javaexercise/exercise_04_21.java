package javaexercise;

import java.util.*;
import java.util.regex.Pattern;

public class exercise_04_21 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        System.out.println("input your SSN:");
        String content = s.nextLine();

        String pattern = "[0-9]{3}-[0-9]{2}-[0-9]{4}";

        System.out.println(content + " is " + (Pattern.matches(pattern, content) ? "a valid" : "an invalid") +
                " social security number.");
    }

}
