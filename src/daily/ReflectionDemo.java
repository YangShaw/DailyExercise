package daily;


public class ReflectionDemo {

    abstract class Operate {
        abstract int compute(int numA, int numB);
    }

    class AddOperate extends Operate {

        @Override
        int compute(int numA, int numB) {
            return numA + numB;
        }
    }

    class SubOperate extends Operate {

        @Override
        int compute(int numA, int numB) {
            return numA - numB;
        }
    }

    public static <T extends Operate> int getResult(int numA, int numB, Class<T> clz) {
        int result = 0;
        try {
            return clz.newInstance().compute(numA, numB);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(getResult(1, 2, AddOperate.class));
    }
}
