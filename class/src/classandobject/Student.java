package classandobject;

/*
在 Java 中一个 .java 源代码文件中可以定义多个类, 但是只能有一个类的类名在定义时可以被 public 修饰,
并且在定义时使用 public 修饰的类的类名必须与它所处的源代码文件名相同.

实际中, 通常一个 .java 源代码文件中只定义一个类, 并且该类被 public 修饰.
*/

// 如果一个被 public 修饰的类的定义中不包含 main 方法, 那么我们将该类称为 JavaBean 类
public class Student {
    // 定义类的成员变量 (类的成员变量也被称为属性)
    String name;
    String education;

    // 定义类的方法 (类的成员方法也被称为行为)
    public void study() {
        System.out.println("student " + name + " is now studying at " + education);
    }
}
