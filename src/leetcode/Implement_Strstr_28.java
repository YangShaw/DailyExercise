package leetcode;

public class Implement_Strstr_28 {

    public static int solution(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length())
                    return i;    //	ƥ�����
                if (i + j == haystack.length())
                    return -1; //ƥ��ʧ��
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;    //	�жϵ�ǰ�Ƿ�ʧ��
            }
        }
    }

    //	һ���̶ȵı��������������Ż�������ǰ��ֹ
    public int strStr(String haystack, String needle) {
        char start = needle.charAt(0);
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i < haystackLength; ++i) {
            if (haystack.charAt(i) != start) {
                //	�����ҵ���ͷƥ��Ĳ���
                continue;
            }
            if (i + needleLength > haystackLength) {
                //	ʣ��δƥ��ĳ����Ѿ�������
                return -1;
            }
            int j;
            for (j = 1; j < needleLength; ++j) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == needleLength) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
