package advancdexercise;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) throws Exception {

        PropertyDescriptor descriptor
                = new PropertyDescriptor("person", PersonDao.class);

        //  得到想要注入属性的具体对象
        Person person = (Person) descriptor.getPropertyType().newInstance();

        //  得到该属性的写方法（也就是setPerson)
        Method method = descriptor.getWriteMethod();

        //  得到该方法的注解
        Annotation annotation = method.getAnnotation(InjectPerson.class);

        //  得到注解上的信息
        Method[] methods = annotation.getClass().getMethods();

        //  将注解上的信息填充到person对象上
        for (Method m : methods) {
            //  得到注解上属性的名字（age或name)
            String name = m.getName();
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
