package advancdexercise.expproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author YangShaw
 * @date 2021/4/9 14:34
 */
public class DynamicProxy {

    public static void main(String[] args) {
        Person zhang = new Student("张三");
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhang);
        // 创建一个代理对象stuProxy来代理张三，代理对象的每个执行方法，都会替换执行invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(
                Person.class.getClassLoader(),
                new Class<?>[]{Person.class},
                stuHandler);
        stuProxy.giveMoney();
    }
}
