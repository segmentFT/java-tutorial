package stringcomparison;

public class StringComparison {
    public static void main(String[] args) {
        /*
        在 Java 中, 对两个具有相同引用数据类型的变量 x1 和 x2 作用等于运算符 ==:

            x1 == x2

        等价于对 x1 和 x2 存储的地址值进行比较, 而不是直接判断 x1 和 x2 分别指向的堆内存中的对象是否相同.
        */

        char[] characters = {'t', 'h', 'e', ' ', 'g', 'r', 'e', 'a', 't', ' ', 'g', 'i', 'g'};

        String s1 = new String(characters);
        String s2 = new String(characters);

        /*
        由于变量 s1 与变量 s2 存储了不同的地址值.

            因为语句:
                String s1 = new String(characters)
            和:
                String s2 = new String(characters)

            分别在堆内存中开辟了两块不同的空间, 用于存储两个不同的 String 类对象 (即使这两个对象存储了相同的字符串内容).

        因此必然有 s1 != s2.
        */
        System.out.println(s1 == s2);

        /*
        对于代码中具有相同内容的字符串字面量, 虚拟机会为它们在串池 (StringTable) 中开辟同一个堆内存空间,
        用于存储与这些字面量具有相同内容的一个 String 类对象.

        因此如果变量 s3 和 s4 分别指向了同一个字符串字面量, 那么它们实际上指向了串池中的同一个 String 类对象,
        因此 s3 和 s4 具有相同的地址值, 从而必然有 s3 == s4.
        */
        String s3 = "the great gig in the sky";
        String s4 = "the great gig in the sky";

        System.out.println(s3 == s4);

        /*
        使用 String 类的成员方法 equals 判断两个 String 类对象存储的字符串内容是否相同.

            该方法对字符串内容中字母的大小写敏感.
        */

        /*
        虽然变量 s1 和 s2 存储的地址值不同, 但是它们指向的 String 类对象记录的字符串内容相同, 因此:

            s1.equals(s2) == true
        */
        System.out.println(s1.equals(s2));

        characters = new char[] {'e', 'c', 'l', 'i', 'p', 's', 'e'};

        String s5 = new String(characters);

        characters = new char[] {'E', 'C', 'L', 'I', 'P', 'S', 'E'};

        String s6 = new String(characters);

        /*
        由于变量 s5 和 s6 指向的 String 类对象具有不同的字符串内容 (考虑字母大小写), 因此:

            s5.equals(s6) == false
        */
        System.out.println(s5.equals(s6));

        // String 类的成员方法 equalsIgnoreCase 与成员方法 equals 类似, 但是前者对被比较的字符串内容中字母的大小写不敏感
        System.out.println(s5.equalsIgnoreCase(s6));
    }
}
