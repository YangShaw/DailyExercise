package daily;

import java.util.*;

public class DSNotes {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        System.out.println(list.size());
        list.remove(1);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        while(stack.empty()){
            System.out.println(stack.peek());
            stack.pop();
            //System.out.println(stack.pop());
        }

        Queue<Integer> queue = new PriorityQueue<>();

    }
}
