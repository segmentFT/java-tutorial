package staticmodifier;

public class StaticModifier {
    public static void main(String[] args) {
        /*
        由于这时 Data 类第一次被使用, 虚拟机会将 Data 类的字节码文件加载到方法区, 同时虚拟机会在堆内存中创建一个名为静态区 (静态存储位置)
        的空间, 用于存放 Data 类的静态变量.

        Data 类在堆内存的静态区中存放该类的静态变量, 由于 Data 类只有一个指向 String 对象的静态变量 staticItem,
        因此虚拟机会在静态区中创建一个 String 类的变量, 并且将它初始化为 null.

            这时在堆内存中没有 Data 类对象, 因为这时没有任何对象的定义语句:

                Data 变量名 = new Data(String 参数)

            被执行.

        之后虚拟机执行赋值语句, 将串池 (StringTable) 中的 String 对象 "Is there anybody in there?" (一个字符串字面量)
        在堆内存中的地址值赋值给静态变量 staticItem.
        */
        Data.staticItem = "Is there anybody in there?";

        /*
        对象的定义语句被执行, 虚拟机在堆内存中创建 Data 类的对象, 只有在这时 Data 类的非静态变量才会被创建.

            Data 类中非静态变量只有 nonStaticItem, 因此这时它在堆内存中被创建.

            之后虚拟机调用 Data 的有参构造函数, 将串池中的 String 对象 "Just nod if you can hear me" (一个字符串字面量)
            在堆内存中的地址值赋值给变量 nonStaticItem.
        */
        Data dataObj1 = new Data("Just nod if you can hear me");

        System.out.println(dataObj1);

        Data dataObj2 = new Data("Come on now");

        // 类的静态变量也可以通过类的实例被调用
        dataObj2.staticItem = "Is there anyone home?";

        /*
        由于 Data 类的静态变量 staticItem 被 Data 类的 2 个实例 (变量 dataObj1 和 dataObj2 指向的对象) 共享.
        而在第一次调用 dataObj1 指向对象的 toString 方法后, Data 类的静态变量 staticItem 存储的地址值通过变量 dataObj2 被修改,
        因此第二次调用 dataObj1 指向对象的 toString 方法会得到不同的字符串内容.
        */
        System.out.println(dataObj1);
        System.out.println(dataObj2);
    }
}
