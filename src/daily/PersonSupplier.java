package daily;

import java.util.Random;
import java.util.function.Supplier;

public class PersonSupplier implements Supplier {

    private int index = 0;
    private Random random = new Random();

    @Override
    public MyPerson get() {
        return new MyPerson(index, "StreamGenerate" + index++, random.nextInt(100));
    }


}
