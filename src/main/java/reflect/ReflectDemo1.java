package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: java反射
 * @Author: LiYang
 * @Date: 2024/9/29 17:50
 */
public class ReflectDemo1 {

    @Test
    public void getClassInfo() {
        // 拿到Class对象
        Class stu = Student.class;
        System.out.println(stu.getSimpleName());
    }

    @Test
    public void getConstructInfo() throws Exception {
        Class stu = Student.class;
        Constructor declaredConstructor = stu.getDeclaredConstructor(int.class, String.class);
        System.out.println(declaredConstructor.getName());
    }

    // 获取单个成员变量对象
    @Test
    public void getFiledInfo() throws Exception {
        Class stu = Student.class;
        // 获取所有的成员变量
        Field[] fileds = stu.getDeclaredFields();
        for (Field field : fileds) {
            System.out.println(field.getName() +
            "(" + field.getType().getName() + ")");
        }
        // 获取单个成员变量
        Field field = stu.getDeclaredField("name");
        System.out.println(field.getName() +
                "(" + field.getType().getName() + ")");
    }
    // 获取类的成员方法对象并对其进行操作
    @Test
    public void getMethodInfo() throws Exception {
        Class stu = Student.class;
        Method[] methods = stu.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "(" + method.getReturnType().getName() + ")" );
        }
        Method method = stu.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);

    }
}
