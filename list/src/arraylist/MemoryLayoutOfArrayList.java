package arraylist;

import java.util.ArrayList;

public class MemoryLayoutOfArrayList {
    public static void main(String[] args) {
        /*
        ArrayList 对象实际上存储的时指向给定数据类型的指针, 因此 ArrayList 类的成员方法 add 的重载:

            boolean add(类型 e)

        实际上进行的是浅拷贝, 它只是将变量 e 存储的地址值进行复制, 而不会真正拷贝 e 指向的对象.
        */
        ArrayList<Data> dataList1 = new ArrayList<>();

        /*
        由于我们向变量 dataList1 指向的 ArrayList 对象中添加了 3 个相互独立的 Data 对象,
        因此这时的 ArrayList 对象中存储了 3 个不同的地址值.
        */
        dataList1.add(new Data("To a life consumed by slow decay"));
        dataList1.add(new Data("The grass was greener"));
        dataList1.add(new Data("The light was brighter"));

        System.out.println(dataList1);

        ArrayList<Data> dataList2 = new ArrayList<>();

        Data dataItem = new Data("With friends surrounded");

        // 由于 add 方法的浅拷贝特性, 这时的 ArrayList 对象中存储了 3 个相同的地址值, 它们指向堆内存中的同一个对象
        dataList2.add(dataItem);
        dataList2.add(dataItem);
        dataList2.add(dataItem);

        System.out.println(dataList2);

        dataItem.setItem("The nights of wonder");

        System.out.println(dataList2);
    }
}
