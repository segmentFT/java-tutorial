package constructor;

public class StudentTest {
    public static void main(String[] args) {
        /*
        创建对象时, 虚拟机会自动调用无参构造方法,
        由于我们再无参构造方法中没有进行任何操作, 因此 student1 指向的对象的成员变量仍然是默认初始化值.
        */
        Student student1 = new Student();

        // 打印出 Student 类的对象的成员变量的默认初始化值
        student1.showStudentInfo();

        System.out.println();

        /*
        创建对象时, 虚拟机会根据构造函数的参数列表, 自动地调用对应的类的构造方法, 这也被称为构造方法的重载.
        在有参构造函数中, 我们根据传入的参数给对应的类的对象的成员变量进行赋值.
        */
        Student student2 = new Student("Ludwig Wittgenstein", 40, "University of Manchester");

        student2.showStudentInfo();
    }
}
