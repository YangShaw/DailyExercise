package daily;

class Sup {
    public void method(Sup obj1, Sup obj2) {
        System.out.println("sup: sup sup");
    }

}

class Sub extends Sup {
    //	��Щ�����������ض�����д�����������̬���ӵ�Ч��

    public void method(Sup o1, Sub o2) {
        System.out.println("sub: sup, sub");
    }

    public void method(Sub o1, Sup o2) {
        System.out.println("sub: sub, sup");
    }

    public void method(Sub o1, Sub o2) {
        System.out.println("sub: sub, sub");
    }
}

public class L {
    public static void main(String[] args) {
        Sup sup = new Sup();
        Sub sub = new Sub();
        Sup supToSub = sub;

        sup.method(sup, sup);
        sup.method(sub, sub);
        sup.method(supToSub, supToSub);

        sub.method(sup, sup);    // sup sup sup
        sub.method(sub, sub);    // sub sub sub
        sub.method(supToSub, supToSub);    //	!sup sup sup

        //	����������sup��sup��ֻ��һ��method����ô�͵���sup�еķ���
        supToSub.method(sup, sup);    //	sup sup sup
        supToSub.method(sub, sub);    //	!sup sup sup
        supToSub.method(supToSub, supToSub);    //	!sup sup sup
    }

}
