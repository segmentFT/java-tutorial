package staticmodifier;

import java.util.StringJoiner;

public class ClassWithStaticMethod {
    private String nonStaticVariable;
    public static String staticVariable;

    public ClassWithStaticMethod() {}

    /*
    类的非静态方法也被称为实例方法, 因为它们必须通过一个类的实例被调用. 假设现在有一个 ClassWithStaticMethod 类的对象:

        ClassWithStaticMethod obj = new ClassWithStaticMethod()

    而 ClassWithStaticMethod 类存在一个实例方法 setNonStaticVariable, 如果我们要调用该方法, 就必须通过该类的实例:

        obj.setNonStaticVariable("")

    方法 setNonStaticVariable 的标准定义:

        public void setNonStaticVariable(String nonStaticVariable) {}

    等价于显式地带有关键字 this 的定义:

        public void setNonStaticVariable(ClassWithStaticMethod this, String nonStaticVariable) {}

    其中 this 可以看作是一个变量, 它的类型是该实例方法所处的类. 参数 this 由虚拟机自动赋值, 我们不能手动向参数 this 传递值.

    虚拟机使得变量 this 存储了调用实例方法 setNonStaticVariable 的对象在堆内存中的地址值,
    这里我们通过变量 obj 调用该方法, 因此这时的 this 存储了 obj 指向的对象在堆内存中的地址值, 即 obj 本身存储的地址值.
    */
    public void setNonStaticVariable(ClassWithStaticMethod this, String nonStaticVariable) {
        System.out.println("the address of caller: " + this);

        /*
        在类的实例方法中访问类的成员变量 (非静态的) 可以通过两种方法:

            1. 直接访问:
                nonStaticVariable = nonStaticVariable

            2. 通过变量 this 访问:
                this.nonStaticVariable = nonStaticVariable

        前者是后者的简写形式, 在作用域不冲突的情况下 (方法内不存在与成员变量重名的局部变量), 当虚拟机在执行方法内的语句时,
        遇到了一个在方法中没有定义的变量 v, 那么它会自动在类的成员变量中寻找 v.
        */
        this.nonStaticVariable = nonStaticVariable;
    }

    public String getNonStaticVariable(ClassWithStaticMethod this) {
        System.out.println("the address of caller (in getter): " + this);

        /*
        类的实例方法的调用必须要通过类的实例, 因此在 ClassWithStaticMethod 的一个实例方法 (这里是 getNonStaticVariable 方法) 内部
        调用同一个类的其他实例方法 (这里是 display 方法) 也需要通过对象 (或者指向对象的变量).

        在类的实例方法中访问同一个类的其他实例方法可以通过两种等价的方法:

            1. 直接通过方法名调用:
                display("she brought from a rubber man")

            2. 通过变量 this 访问:
                this.display("she brought from a rubber man")

        前者是后者的简写形式. 因为 display 是实例方法, 根据它的完整定义:

            public void display(ClassWithStaticMethod this) {
                System.out.println("a displayed message");
            }

        它的参数 this 需要接受一个 ClassWithStaticMethod 对象的地址值. 而虚拟机会自动将调用该实例方法 (这里是 getNonStaticVariable
        方法) 的变量 this 存储的地址值赋值给被调用的另一个实例方法 (这里是 display 方法) 的参数 this.

        因此调用 display 在语义上类似于:
            display(this, "she brought from a rubber man")

        调用方法 (getNonStaticVariable) 和被调用方法 (display) 的参数 this 指向同一个在堆内存上的 ClassWithStaticMethod 对象.
        */
        this.display("she brought from a rubber man");

        return this.nonStaticVariable;
    }

    public void display(ClassWithStaticMethod this, String extraMessage) {
        System.out.println("the address of caller (in method \"display\")" + this);

        System.out.println(
                new StringJoiner("---").add("a displayed message").add(extraMessage)
        );
    }

    /*
    类的静态方法中没有参数 this.

    由于 ClassWithStaticMethod 类的实例变量 (非静态成员变量) 和实例方法 (非静态成员方法) 都需要通过 ClassWithStaticMethod 对象或者
    指向它的变量进行访问. 在 staticMethod 方法中调用同一个类的其他的实例方法和实例变量, 等同于通过 staticMethod 方法的参数 this 进行
    调用, 比如:

        this.display
        this.nonStaticMethod

    而 staticMethod 方法没有参数 this, 因此它不能直接访问类的其他实例变量和方法 (即在方法体的内部通过名字直接访问).

    但是静态方法可以直接访问同一个类的其他静态变量.

    因为当 ClassWithStaticMethod 类第一次被使用时 (无论是通过类名访问静态变量或方法, 还是通过 new 关键字创建对象),
    虚拟机会将 ClassWithStaticMethod 类的字节码加载到方法区中, 同时类的静态变量就会在堆内存的静态区中被创建,

    又因为类的字节码已经被加载到方法区中, 因此类的静态方法也可以被访问. 但是这时类的对象可能没有被创建, 如果静态方法能够访问类的实例变量, 那么在
    对象被创建之前通过静态方法访问一个对象的实例变量在语法上就是被允许的, 但这是内存不安全的操作, 因为静态方法会访问不存在的变量或对象.
    */
    public static void staticMethod() {
        System.out.println("a static method has been called");

        System.out.println("static variable: " + staticVariable);
    }

    /*
    实例方法可以访问静态变量, 因为静态变量有两种访问方式:

        1. 通过类名访问
        2。通过类的实例或者指向一个实例的变量访问

    变量 this 是一个指向对象的变量, 因此通过变量 this 访问同一个类中的静态变量. 同理, 实例方法可以访问静态方法.
    */
    public void nonStaticMethod(ClassWithStaticMethod this) {
        System.out.println("a non-static method has been called");

        System.out.println("static variable: " + this.staticVariable);

        this.staticMethod();
    }
}
