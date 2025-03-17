package reflect;

import lombok.Data;

/**
 * @Description: 学生类
 * @Author: LiYang
 * @Date: 2024/9/29 17:51
 */
@Data
public class Student {
    private String name;
    private int age;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
