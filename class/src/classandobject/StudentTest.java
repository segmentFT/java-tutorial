package classandobject;

/*
在 Java 中, 一个 .java 源代码文件中可以同时定义多个类, 但是这些类的定义中, 只有一个类的类名能够在定义时被 public 修饰,
并且在定义时类名被 public 修饰的类名必须与该类所处的 .java 源代码文件的文件名相同.

通常每个源代码文件中只会定义一个类, 并且在该类的定义中, 类名被 public 修饰, 且类名与该源代码文件的文件名相同.
*/

// 如果一个类中包含 main 方法, 那么我们称该类为测试类
public class StudentTest {
    public static void main(String[] args) {
        // 创建新的 Student 类的对象
        Student student1 = new Student();
        Student student2 = new Student();

        // 通过成员访问运算符 . 访问类的对象的属性和行为
        student1.name = "Bertrand Russell";
        student1.education = "Trinity College, Cambridge";

        student2.name = "Ludwig Wittgenstein";
        student2.education = "University of Manchester";

        student1.study();
        student2.study();
    }
}
