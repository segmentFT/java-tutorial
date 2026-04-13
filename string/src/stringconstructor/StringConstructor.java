package stringconstructor;

public class StringConstructor {
    public static void main(String[] args) {
        /*
        在 Java 中字符串字面量是一个 java.lang.String 对象, 可以将它直接赋值给一个 String 类型的变量,
        由于 String 类型是引用类型, 因此 String 类型的变量存储了堆内存中实际的字符串对象的地址.
        */
        String s1 = "the lunatic is on the grass";

        System.out.println(s1);

        // 调用 String 类的无参构造函数创建 String 类的对象, 这时得到的对象存储了一个空字符串
        String emptyString = new String();

        System.out.println(emptyString);
        System.out.println("every" + emptyString + "thing");

        /*
        调用 String 类的有参构造函数创建 String 类的对象, 其中构造函数的参数是另一个 String 对象:

            String 变量名 = new String(字符串对象)

        其中的字符串对象可以是字面量. 上面的语句等价于:

            String 变量名 = 字符串对象
        */
        String s2 = new String("the lunatic is in the hall");

        System.out.println(s2);

        /*
        调用 String 类的有参构造函数创建字符串对象, 其中构造函数的参数是字符数组类型 (即 char[] 类型) 的变量.
        该变量指向堆内存中实际的字符数组对象.
        */
        char[] characters = {'I', 'n', ' ', 't', 'h', 'e', ' ', 'f', 'l', 'e', 's', 'h'};

        String s3 = new String(characters);

        System.out.println(s3);

        /*
        调用 String 类的有参构造函数创建字符串对象, 其中构造函数的参数是字节数组类型 (即 byte[] 类型) 的变量.
        该变量指向堆内存中实际存在的字节数组对象.

            作为参数传入的变量指向的 byte 类型数组中的每个元素 (byte 类型) 被解释为 ASCII 码.
        */
        byte[] bytes = {69, 99, 108, 105, 112, 115, 101};

        String s4 = new String(bytes);

        System.out.println(s4);
    }
}
