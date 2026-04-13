package stringbuilder;

public class StringBuilderDemonstration {
    public static void main(String[] args) {
        /*
        Java 中的 StringBuilder 类对象与 String 类对象类似, 用于存储字符串内容.

            但是 StringBuilder 类对象中存储的字符串内容是可变的;
            而 String 类对象是一个常量, 它在被创建后存储的内容不能被改变.
        */

        // 通过 StringBuilder 类的无参构造函数创建一个空的 StringBuilder 对象, 该对象中不含有任何字符串内容
        StringBuilder sb1 = new StringBuilder();

        /*
        Java 中 StringBuilder 类的成员方法 toString 已经被重载, 它返回 StringBuilder 类对象的属性值,
        因此函数 System.out.println 函数将打印 StringBuilder 类对象存储的字符串内容.
        */
        System.out.println(sb1);


        /*
        通过 StringBuilder 类的有参构造函数接受 String 类对象或者指向 String 类对象的变量作为参数.

            该构造函数将传入的 String 类对象中存储的字符串作为新创建的 StringBuilder 类对象中初始的字符串内容.
        */
        StringBuilder sb2 = new StringBuilder("a brick in the wall");

        System.out.println(sb2);

        // 通过 StringBuilder 类的成员方法 append 向 StringBuilder 对象中添加新的字符串内容

        // append 方法可以接受整数, 该整数将会被自动转化为字符串并且添加在 StringBuilder 对象中已有的字符串内容之后
        sb1.append(12);

        // append 方法可以接受浮点数, 该浮点数将会被自动转化为字符串并且添加在 StringBuilder 对象中已有的字符串内容之后
        sb1.append(34.56);

        // append 方法可以接受 boolean 类型的值, 它会被自动转化为字符串并且添加在 StringBuilder 对象中已有的字符串内容之后
        sb1.append(false);

        System.out.println(sb1);

        /*
        由于 append 方法会返回调用它的 StringBuilder 对象本身, 因此 append 方法可以通过链式调用,
        向同一个 StringBuilder 对象中添加多个字符串内容.
        */
        sb1.append(" first").append(" second").append(" third");

        /*
        StringBuilder 类的成员方法 reverse 会将 StringBuilder 对象中存储的字符串中字符的顺序颠倒.

            该操作是原地的, 即它会修改 StringBuilder 对象中存储的字符串内容.
        */
        sb2.reverse();

        System.out.println(sb2);

        // StringBuilder 类的成员方法 length 返回 StringBuilder 对象中存储的字符串的长度 (字符串内容中字符的数量)
        System.out.println(sb1.length());
        System.out.println(sb2.length());

        /*
        StringBuilder 类的成员方法 toString 将一个 StringBuilder 对象中存储的字符串内容包装为一个新的 String 对象,
        并且返回该 String 对象.
        */
        String s1 = sb1.toString();
        String s2 = sb2.toString();

        System.out.println(s1);
        System.out.println(s2);
    }
}
