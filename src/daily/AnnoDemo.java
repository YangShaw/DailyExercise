package daily;

import java.lang.reflect.Method;

public class AnnoDemo {

    @MyAnno(userName = "shaw", age = 20)
    public static void getInfo(String userName, int age) {
        System.out.println(userName);
        System.out.println(age);
    }

    public static void main(String[] args) throws Exception {

        //  需要通过下面的设置来把注解上的信息和方法上的信息关联起来
        //  框架中会帮你配置好，但是自定义的注解要自己配置一下

        //  通过反射得到该类的方法
        Class annoDemoClass = AnnoDemo.class;
        Method method = annoDemoClass.getMethod("getInfo", String.class, int.class);

        //  通过该方法得到注解上的具体信息
        MyAnno myAnno = method.getAnnotation(MyAnno.class);
        String userName = myAnno.userName();
        int age = myAnno.age();

        //  将注解上的信息注入到方法中
        Object object = annoDemoClass.newInstance();
        method.invoke(object, userName, age);
    }
}
