package stringbuilder;

public class MemoryLayoutOfStringBuilder {
    public static void main(String[] args) {
        // 如果在字符串的拼接操作中, 参与拼接操作的 String 对象都是字符串字面量:
        String separateStrings = "The" + " lunatic" + " is" + " on" + " the" + " grass.";

        /*
        那么在编译时, 编译器会直接计算出拼接后的字符串内容.

        因此考虑如下的拼接后的字符串:
        */
        String concatenatedString = "The lunatic is on the grass.";

        // 那么如下的比较结果为 true:
        System.out.println(separateStrings == concatenatedString);

        /*
        这是因为变量 concatenatedString 指向的 String 对象处于堆内存的串池 (StringTable) 中,
        当编译器在编译时期会直接计算如下的表达式:

            "The" + " lunatic" + " is" + " on" + " the" + " grass."

        得到一个新的字符串字面量, 因此语句:

            String separateStrings = "The" + " lunatic" + " is" + " on" + " the" + " grass."

        等价于语句:

            String separateStrings = "The lunatic is on the grass."

        因此当虚拟机开始执行程序时, 变量 separateStrings 指向的 String 对象也会处于串池中.

        由于虚拟机只会在串池中为多个具有相同内容的字符串字面量创建一个 String 对象,
        又因为这时的变量 separateStrings 和 concatenatedString 指向了串池中具有相同内容的 String 对象,
        即它们指向了同一个堆内存的对象, 因此虚拟机会为它们赋予相同的地址值.
        */

        /*
        如果在字符串的拼接操作中有非字符串字面量参与 (比如指向 String 对象的变量):

        那么在 JDK 8 之前, 虚拟机会在底层使用 StringBuilder 类, 通过 StringBuilder 类的成员方法 append 完成字符串拼接操作.

        虚拟机在 main 方法的栈帧中为变量 word1 开辟空间, 同时在串池中查找是否有 String 对象的内容为 "The lunatic",
        由于这时串池中没有满足的 String 对象, 因此虚拟机会在串池中创建一个新的 String 对象,
        并将它的堆内存地址值赋值给变量 word1.
        */
        String word1 = "The lunatic";

        /*
        虚拟机这时遇到字面量 " is in", 它会在串池中寻找存储的字符串内容为 " is in" 的 String 对象,
        由于在串池中不存在这样的 String 对象, 因此虚拟机会在串池中创建一个新的 String 对象.

        由于这时的字符串拼接操作符的左侧不是字面量, 因此虚拟机会在堆内存中创建一个 StringBuilder 对象：

            obj1 = new StringBuilder()

        之后通过 StringBuilder 类的成员方法 append 将字符串 "The lunatic" 与 " is in" 拼接:

            obj1.append("The lunatic")
            obj1.append(" is in")

        再通过 StringBuilder 类的成员方法 toString 将拼接后的字符串 "The lunatic is in" 包装成一个新的 String 对象:

            str1 = obj1.toString()

        之后虚拟机为变量 word2 在 main 方法的栈帧中开辟空间, 并且将该 String 对象在堆内存中的地址值 str1 赋给变量 word2.

        因此语句:
            String word2 = word1 + " is in"

        等价于语句:
            String word2 = new StringBuilder().append(word1).append(" is in").toString()
        */
        String word2 = word1 + " is in";

        /*
        同理, 语句:
            String word3 = word2 + "the hall"

        等价于:
            String word3 = new StringBuilder().append(word2).append(" the hall").toString()

        虚拟机在 main 方法的栈帧中为变量 word3 开辟空间, 并且将该语句 toString 方法返回的新的 String 对象的地址值赋值给变量 word3.
        */
        String word3 = word2 + " the hall";

        System.out.println(word3);

        /*
        因此在 JDK 8 之前, 语句:

            String word1 = "The lunatic"
            String word2 = word1 + " is in"
            String word3 = word2 + " the hall"

        等价于:

            String word1 = "The lunatic"
            String word2 = new StringBuilder().append(word1).append(" is in").toString()
            String word3 = new StringBuilder().append(word2).append(" the hall").toString()

         该过程会创建 2 个临时的 StringBuilder 对象.
        */

        /*
        同理在 JDK 8 之前, 下面的代码等价于:

            obj1 = new StringBuilder().append(word4).append(word5).toString()
            obj2 = new StringBuilder().append(obj1).append(word6).toString()

            concatenatedWords = obj2

        因此由于字符串拼接操作符的左结合性, 3 个非字符串字面量的 String 对象的拼接操作需要创建 2 个临时的 StringBuilder 对象.
        */
        String word4 = "The lunatic ";
        String word5 = "is in ";
        String word6 = "my mind";
        String concatenatedWords = word4 + word5 + word6;

        /*
        在 JDK 8 之后, 虚拟机在执行语句:

            word4 + word5 + word6

        时, 由于参与拼接运算的有 3 个操作数 (它们不全都是字符串字面量), 因此虚拟机会临时创建一个长度为 3 的 String 类型的数组:

            String[] arr = new String[3]

        并且将变量 word4, word5, word6 存储的地址值分别赋给临时数组 arr 的元素:

            arr[0] = word4
            arr[1] = word5
            arr[2] = word6

        并且虚拟机会将数组 arr 中变量指向的 String 对象一次性地拼接成一个新的 String 对象.
        */

        System.out.println(concatenatedWords);

        //
        StringBuilder builder1 = new StringBuilder();

        /*
        StringBuilder 类的对象是一个存储内容可变的容器, 因此通过 StringBuilder 对象的字符串拼接操作会直接修改对象,
        从而语句:

            builder1.append("plastic").append("fake").append("tree")

        除了创建在串池中的 String 对象外, 只有一个 StringBuilder 对象被创建.
        */
        builder1.append("plastic").append("fake").append("tree");

        System.out.println(builder1);

        /*
        当使用 StringBuilder 类的无参构造函数创建 StringBuilder 对象时, 该构造函数会同时创建一个长度为 16 的字节数组.
        该字节数组的长度由 StringBuilder 对象的属性 capacity 记录:
        */
        StringBuilder builder2 = new StringBuilder();

        System.out.println("capacity: " + builder2.capacity());
        System.out.println("length: " + builder2.length());

        /*
        当通过 StringBuilder 类的成员方法 append 添加的新字符串的长度小于 16 时,
        不会引起对象的扩容机制, 即, 这时对象中的字节数组的长度不变, 从而属性 capacity 也不变:
        */
        builder2.append("the bends");

        System.out.println("capacity: " + builder2.capacity());

        /*
        但是 StringBuilder 对象中存储的字符串内容发生了改变, 因此对象的长度属性 count 会发生变化,

            属性 count 表示对象中存储的字符串的字符数量.
        */
        System.out.println("length: " + builder2.length());

        /*
        假设当前的 StringBuilder 对象的属性 capacity 等于 N, 如果通过方法 append 添加新的字符串 x 后,
        x 与对象中保存的字符串 y 拼接后获得的字符串 z 的长度仍然小于:

            2 * N + 2

        那么该对象会将其内部的字符数组的长度扩充到 (2 * N + 2), 从而属性 capacity 也变为 (2 * N + 2).
        */
        builder2.append("high and dry");

        /*
        原先的 builder2 指向的 StringBuilder 对象的属性 count 为 9, 属性 capacity 为 16,
        在该对象被添加新的字符串后, 拼接后的字符串长度应为 21, 小于:

            2 * 16 + 2 = 34

        因此对象的属性 capacity 变为 34, 而属性 count 变为 21.
        */
        System.out.println("capacity: " + builder2.capacity());
        System.out.println("length: " + builder2.length());

        /*
        如果通过 StringBuilder 对象的成员方法 append 向该对象添加字符串 x 后,
        对象中原先保存的字符串 y 与 x 拼接后得到的字符串 z 的长度大于:

            2 * N + 2

        那么该对象会直接将其内部的字节数组组的长度扩充到 z 的长度, 从而属性 capacity 等于 z 的长度.
        */
        builder2.append("Her green plastic watering can for a fake Chinese rubber plant");

        /*
        在调用 append 方法前 builder2 指向的 StringBuilder 对象的属性 count 为 21, 属性 capacity 为 34,
        现在我们向该对象通过 append 方法添加了 62 个字符 (长度为 62 的字符串),
        那么新的字符串与对象中保存的字符串拼接后的字符串长度为:

            62 + 21 = 83

        而如果当前的对象进行一次扩容, 那么其内部的字节数组的长度变为:

            34 * 2 + 2 = 70

        而明显有 70 < 83, 从而扩容后, 对象的属性 count 和 capacity 都等于 83.
        */
        System.out.println("capacity: " + builder2.capacity());
        System.out.println("length: " + builder2.length());
    }
}
