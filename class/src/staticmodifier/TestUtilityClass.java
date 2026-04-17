package staticmodifier;

public class TestUtilityClass {
    public static void main(String[] args) {
        /*
        Java 中类的静态方法可以通过类的实例调用, 也可以直接通过类名调用.

            由于标准的工具类的构造方法是私有的 (方法在定义时被修饰符 static 修饰), 因此在其他类中无法创建工具类的对象,
            因此工具类的静态方法只能通过类名调用.
        */
        String str = UtilityClass.staticMethod("her green plastic water can");

        System.out.println(str);
    }
}
