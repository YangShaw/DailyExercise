package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
// A(0,0,10) B(A,1,5) C(A,2,12) D(B,1,4) E(B,2,7)
// A(0,0,10) B(A,1,6) C(A,2,7) D(B,1,8) E(B,2,5) F(C,1,4) G(C,2,9)

public class Question4 {

    static class Point {
        public String name;
        public String father;
        public int pos;
        public int value;

        public Point(String input) {
            String[] infos = input.split(" ");
            name = infos[0];
            father = infos[1];
            pos = Integer.parseInt(infos[2]);
            value = Integer.parseInt(infos[3]);
        }
    }

    public static Map<String, Point[]> map;
    public static List<Integer> result;
    public static int sum = 0;    //	��ǰ�ܺ�
    public static int target = 0;

    public static String preProcess(String input) {
        input = input.replace(',', ' ');
        input = input.replace('(', ' ');
        input = input.replace(')', ' ');
        return input;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        target = s.nextInt();
        s.nextLine();
        String info = s.nextLine();
        String[] infoArray = info.split(" ");
        List<Point> points = new LinkedList<Point>();

        map = new HashMap<String, Point[]>();
        // �洢�ڵ���Ϣ
        for (String str : infoArray) {
            str = preProcess(str);
            Point point = new Point(str);
            if (!map.containsKey(point.father)) {    //	���û�洢������ڵ�
                Point[] temp = new Point[2];
                temp[0] = point;
                map.put(point.father, temp);
            } else {
                map.get(point.father)[1] = point;
            }
        }

        Stack<Integer> stack = new Stack<Integer>();
        result = new ArrayList<Integer>();
        Point root = map.get("0")[0];
        sum = sum + root.value;
//		stack.add(root.value);
        result.add(root.value);
        dfs(root.name);

    }

    public static void dfs(String name) {
        if (map.containsKey(name)) {
            Point p1 = map.get(name)[0];
            result.add(p1.value);
            sum = sum + p1.value;
            dfs(p1.name);

            Point p2 = map.get(name)[1];
            if (p2 != null) {
                result.add(p2.value);
                sum = sum + p2.value;
                dfs(p2.name);
            }
        }
        if (sum == target) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        int count = result.size() - 1;
        sum = sum - result.get(count);
        result.remove(count);

    }

}
