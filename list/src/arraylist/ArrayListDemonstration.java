package arraylist;

import java.util.ArrayList;

public class ArrayListDemonstration {
    public static void main(String[] args) {
        /*
        Java 中的 ArrayList 对象是一个只能存储引用数据类型的动态数组, 其存储的内容可变, 并且 ArrayList 对象的长度可变.
        如果要在 ArrayList 对象中存储整数, 浮点数, 字符或 Boolean 等基本数据类型, 那么需要使用包装类.

        ArrayList 类使用了泛型机制, 在创建指向 ArrayList 对象的变量以及调用 ArrayList 类的构造函数创建对象时,
        需要指定 ArrayList 对象存储元素的类型.

        在 JDK 7 之前, 定义 ArrayList 对象的语句格式如下:

            ArrayList<类型1> 变量名 = new ArrayList<类型2>()

        但是在 JDK 7 之后, 该语句中赋值运算符右侧的 ArrayList 类的括号 <> 内的 "类型2" 可以被省略,
        因为在该定义语句中, "类型1" 和 "类型2" 必须是一致的.

        因此在 JDK 7 之后, 该定义语句等价于:

            ArrayList<类型> 变量名 = new ArrayList<>()
        */
        ArrayList<String> stringList = new ArrayList<>();

        /*
        ArrayList 类中的 toString 方法已经被重载,
        该成员方法返回 ArrayList 对象内部存储的所有对象的 toString 方法返回的字符串内容拼接后的结果.
        */
        System.out.println(stringList);

        String str = stringList.toString();
        System.out.println(str);

        /*
        ArrayList 类的成员方法 add 用于向 ArrayList 对象中添加元素,
        而添加的元素必须是与 ArrayList 对象被创建时通过括号 <> 指定的类型相容.

        方法 add 的第一个重载如下:

            boolean add(类型 e)

        该方法的返回值表示添加操作是否成功. ArrayList 类保证添加操作一定成功, 因此 add 方法一定返回 true.
        */
        boolean isAdditionSuccessful = stringList.add("In a world of magnets and miracles");

        System.out.println(isAdditionSuccessful);
        System.out.println(stringList);

        isAdditionSuccessful = stringList.add("Our thoughts strayed constantly");
        System.out.println(isAdditionSuccessful);
        System.out.println(stringList);

        isAdditionSuccessful = stringList.add("and without boundary");
        System.out.println(isAdditionSuccessful);
        System.out.println(stringList);

        /*
        ArrayList 类的成员方法 remove 用于从 ArrayList 对象中删除元素. 它的第一个重载如下:

            boolean remove(类型 e)

        该方法查找 ArrayList 对象中存储的第一个与变量 e 指向的对象相同的元素, 并且将该元素删除.
        如果这样的元素存在, 那么删除成功, 该方法返回 true, 否则删除失败, 该方法返回 false.
        */
        boolean isRemovalSuccessful = stringList.remove("In a world of magnets and miracles");

        System.out.println(isRemovalSuccessful);
        System.out.println(stringList);

        isRemovalSuccessful = stringList.remove("Beyond the horizon of the place");

        System.out.println(isRemovalSuccessful);
        System.out.println(stringList);

        /*
        ArrayList 类的成员方法 remove 的第二个重载如下:

            类型 remove(int index)

        该方法删除 ArrayList 对象中存储的下标为 index 的元素, 并且将被删除的元素的地址值返回.

            如果下标为 index 的元素在 ArrayList 对象中不存在, 那么 remove 方法会抛出越界异常.
        */
        String removedElement = stringList.remove(0);

        System.out.println(removedElement);
        System.out.println(stringList);

        /*
        ArrayList 类的成员方法 set 的定义如下:

            类型 set(int index, 类型 e)

        该方法会将 ArrayList 对象中, 原先位于下标 index 的元素替换为变量 e 指向的对象, 并且将原先的对象返回.

            如果下标为 index 的元素在 ArrayList 对象中不存在, 那么 set 方法会抛出越界异常.
        */
        String replacedElement = stringList.set(0, "The ringing of the division bell has begun");

        System.out.println(replacedElement);
        System.out.println(stringList);

        /*
        ArrayList 类的成员方法 get 的定义如下:

            类型 get(int index)

        该方法会将 ArrayList 对象中存储的下标为 index 的元素的地址值返回.

            如果下标为 index 的元素在 ArrayList 对象中不存在, 那么 get 方法会抛出异常.
        */
        String foundElement = stringList.get(0);

        System.out.println(foundElement);

        // ArrayList 类的成员方法 size 返回 ArrayList 对象中存储的元素数量
        System.out.println(stringList.size());

        // 遍历 ArrayList 对象中的元素
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
    }
}
