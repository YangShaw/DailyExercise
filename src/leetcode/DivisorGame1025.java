package leetcode;

public class DivisorGame1025 {

    public boolean solution(int n) {
        return n % 2 == 0;
    }

    //	�Ҹо���д�Ĵ������ѧ�����Ƶȵ��������Լ��Ϳ������ˡ���
    //	�ݹ�ķ�����ʱ�临�Ӷ�̫��

    public boolean divisorGame(int n) {

        if (n == 1) {
            return false;
        }
        return game(n, true);
        //	1һ����������
    }

    public boolean game(int n, boolean flag) {
        if (n == 2) {
            //	��Ӯ�����flag=true��Ҫ��Ӯ����ô���������Ӯ��
            return flag;
        }

        //	1һ����������
        //	ѡ��1��ζ�Ź���һ�֣���ô�����Ҫ���������Ӯ
        if (game(n - 1, !flag) == flag) {
            return flag;
        } else {
            for (int i = 2; i < n; ++i) {
                if (n % i == 0) {
                    if (game(n - i, !flag) == flag) {
                        return flag;
                    }
                }
            }
        }
        return !flag;
    }

}
