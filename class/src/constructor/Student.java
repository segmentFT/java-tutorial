package constructor;

public class Student {
    private String name;
    private int age;
    private String education;

    // 如果类中没有显式地定义任何构造方法, 那么虚拟机会自动的生成一个无参构造方法

    /*
    类的构造方法没有返回值, 并且没有返回值类型 (包括 void 类型),
    并且类的构造方法与类名相同.
    */
    public Student() {
        System.out.println("construct without parameters has been called.");
    }

    /*
    一旦显式地为类定义了构造方法 (无论是有参数的还是无参数的), 即使类中不存在无参构造方法, 虚拟机也不会自动生成无参构造方法,
    因此实, 如果在定义了类的有参构造方法的同时, 还需要在之后创建对象时使用无参构造方法, 那么就需要手动地显式地定义无参构造方法.
    */
    public Student(String name, int age, String education) {
        this.name = name;
        this.age = age;
        this.education = education;

        System.out.println("constructor with parameters has been called.");
    }

    public void showStudentInfo() {
        System.out.println(age + "-year-old student " + name + " is educated at " + education);
    }
}
