package leetcode;

public class Length_of_Last_Word_58 {

    //	���ַ����ٶȸ�����˵��������split������.Ҳ�ԣ�ȷʵû��Ҫ����split��
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        int l = array.length;
        if (l == 0) {
            return 0;
        }
        return array[l - 1].length();
    }


    //	���¡�֮ǰ��д�Ķ���Щɶ����= =
    public static int solution(String s) {
        s = s.trim();
        int p = s.lastIndexOf(' ');
        int n = s.length();
        return n - p - 1;
    }


}
