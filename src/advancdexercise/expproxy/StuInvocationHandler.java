package advancdexercise.expproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author YangShaw
 * @date 2021/4/9 14:46
 */
public class StuInvocationHandler<T> implements InvocationHandler {
    T target;
    public StuInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" + method.getName());
        Object res = method.invoke(target, args);
        return res;
    }
}
