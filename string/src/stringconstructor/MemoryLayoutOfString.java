package stringconstructor;

public class MemoryLayoutOfString {
    public static void main(String[] args) {
        /*
        在 Java 中, 堆内存中有一块专门用于存储代码中字符串字面量的区域, 被称为字符串常量池 (StringTable, 串池),
        虚拟机会为代码中具有相同内容的字符串字面量在串池中开辟空间, 用于创建存储该字符串字面量的 String 类的对象.
        */

        /*
        main 方法在栈内存的栈帧中被开辟出一块空间, 用于创建指向 String 类的对象的变量 s1.

        这时在串池中不存在存储字符串字面量 "But the sun is eclipsed by the moon" 的 String 类的对象,
        因此虚拟机在串池中创建一个新的 String 类对象, 存储字面量 "But the sun is eclipsed by the moon",
        并且将该 String 类对象在堆内存中的地址值赋值给变量 s1.
        */
        String s1 = "But the sun is eclipsed by the moon";

        /*
        虚拟机在 main 方法的栈帧中开辟新的空间, 用于创建指向 String 类的对象的变量 s2.

        由于在串池中已经存在一个存储的内容与字面量 "But the sun is eclipsed by the moon" 相同的 String 类的对象,
        因此虚拟机会直接将该 String 类的对象在堆内存中的地址值赋给变量 s2.
        */
        String s2 = "But the sun is eclipsed by the moon";

        // 因此这时的 s1 和 s2 指向了串池中相同的 String 类对象.

        System.out.println(s1);
        System.out.println(s2);

        /*
        通过 new 关键字调用 String 类的构造函数, 从而显式地在堆内存中创建获得的 String 类的对象不会存储在串池中,
        因此调用 String 类的构造函数创建两个具有相同内容的 String 类对象, 在堆内存中相互独立.
        */

        char[] characters = {'B', 'r', 'a', 'i', 'n', ' ', 'D', 'a', 'm', 'a', 'g', 'e'};

        /*
        虚拟机在 main 方法的栈帧中创建指向 String 类对象的变量 s3.

        之后虚拟机通过调用 String 类的构造函数

            public String(char[] values)

        在堆内存中开辟一块新的空间, 用于创建 String 类的对象, 并且将该对象的地址值赋值给变量 s3
        */
        String s3 = new String(characters);

        /*
        虚拟机在 main 方法的战阵中创建指向 String 类对象的变量 s4.

        之后同理, 虚拟机调用相同的构造函数, 根据同一个变量 characters 指向的相同的字符数组对象,
        在堆内存中开辟一块额外的空间, 创建一个新的 String 类的对象, 并且将该新的对象的地址值赋值给变量 s4.
        */
        String s4 = new String(characters);

        /*
        因此即使 s3 和 s4 指向了堆内存中具有相同字符串内容的 String 类对象, 但是 s3 和 s4 存储的地址值不同,
        因为它们实际指向了两个相互独立的对象.
        */

        System.out.println(s3);
        System.out.println(s4);
    }
}
