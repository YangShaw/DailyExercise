package leetcodegrindingguide;

import java.util.*;

public class Exe {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = "hello world";
        str = str.replace("llo", "new");
        System.out.println(str);

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Collections.sort(list, (a, b) -> {
             if (a > b) {
                 return 1;
             }
             return -1;
        });

        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        System.out.println(Character.isDigit('5'));


    }
}
