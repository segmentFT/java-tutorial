package staticmodifier;

import java.util.StringJoiner;

public class Data {
    private String nonStaticItem;

    /*
    被 static 修饰符修饰的类的成员变量被称为静态变量.

    一个类的静态变量被同一个类的不同实例共享. 当类的字节码被加载到方法区时, 虚拟机会在堆内存的一块被称为静态区 (静态存储位置)
    的内存空间中创建静态变量, 而堆内存中同一个类的不同实例的静态变量实际上是静态区中的同一个变量.

    类的静态变量优先于非静态变量被创建, 因为非静态变量只有在类的对象被创建时才会被创建. 对象的定义语句:

        new 类的构造函数(参数)

    被执行时, 类的字节码需要被加载到方法区中, 这时类的静态变量会立刻在静态区中被创建, 之后类的对象才会在堆内存中被创建.

    对于该 Data 类的被 public 关键字修饰的静态属性 staticItem, 由两种方式可以访问它:

        1. 通过类的实例访问:

            Data obj = new Data()
            obj.staticItem

        2. 直接通过类名被访问:

            Data.staticItem

    在这两种方式中, 一定是类的静态变量最先被创建并初始化, 因为类的字节码被加载到方法区的同时, 静态区中的静态变量就会被创建.
    */
    public static String staticItem;

    public Data() {}

    public Data(String nonStaticItem) {
        this.nonStaticItem = nonStaticItem;
    }

    public void setNonStaticItem(String nonStaticItem) {
        this.nonStaticItem = nonStaticItem;
    }

    public String getNonStaticItem() {
        return nonStaticItem;
    }

    public String toString() {
        return new StringJoiner("\n").add(staticItem).add(nonStaticItem).toString();
    }
}
