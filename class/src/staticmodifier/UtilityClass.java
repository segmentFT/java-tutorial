package staticmodifier;

import java.util.StringJoiner;

/*
Java 中标准的工具类需要满足:

    1. 类的构造方法必须用修饰符 private 修饰, 这意味工具类的构造函数无法在其他类中被调用, 由于类的对象的定义语句:

           类型 变量名 = new 构造函数(参数列表)

       中需要显式地调用类的构造函数, 因此在其他类中无法显式地创建工具类的实例.

    2. 类中所有的方法都由修饰符 static 修饰, 即类的所有方法 (行为) 都是静态方法.

*/
public class UtilityClass {
    private UtilityClass() {}

    public static String staticMethod(String str) {
        return new StringJoiner("", ">>>", "<<<").add(str).toString();
    }
}
