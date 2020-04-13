package daily;

import java.util.*;

public class Question3 {

    public static void main(String[] args) {
        // input
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
//		char[] inputarr = input.toCharArray();
//		Arrays.sort(inputarr);
        List<String> result = solution(input);
        Collections.sort(result);
        for (String res : result) {
            System.out.print(res + " ");
        }
    }

    public static List<String> solution(String input) {
        List<String> list = new LinkedList<String>();
        if (input.length() == 1) {
            list.add(input);
            return list;
        }

        for (int i = 0; i < input.length(); ++i) {
            StringBuilder inputBuilder = new StringBuilder(input);

            // ��index i��ͷ���������
            char cur = input.charAt(i);
            StringBuilder sb = new StringBuilder(cur + "");
            String last = inputBuilder.deleteCharAt(i).toString();

            List<String> temp = solution(last);
//			System.out.println(temp);

            for (int j = 0; j < temp.size(); ++j) {
                sb.append(temp.get(j));
                list.add(sb.toString());
                sb = new StringBuilder(cur + "");
            }
        }

        return list;
    }
}
