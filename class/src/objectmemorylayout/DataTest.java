package objectmemorylayout;

/*
DataTest 类的字节码文件 (.class 文件) 首先被加载到方法区中,
从而 DataTest 类的程序入口 main 方法也被临时存储在方法区中.
*/
public class DataTest {

    // 虚拟机自动调用程序的主入口 main 方法, 从而虚拟机在栈内存中自动创建 main 方法的栈帧
    public static void main(String[] args) {
        Data dataObj = new Data();
        /*
        1. 虚拟机首先将 Data 类的字节码文件 Data.class 加载到方法区中,
           与 Data 类中所有的成员变量 (这里为变量 data) 以及成员方法 (这里为方法 showData) 有关的信息也会加载到方法区中.

        2. 在栈内存中的 main 方法的栈帧中开辟存储 Data 类的对象的地址值的变量 dataObj.

        3. 在堆内存中为 Data 类的对象开辟空间, 并且将 Data 类中成员方法的地址保存到该开辟出的空间中

               由于 Data 类中只保存成员方法的地址,
               因此在堆内存中的不同的 Data 类的对象中保存的成员方法的地址实际上指向了方法区中同一个方法的字节码.

               从而不同 Data 类的对象之间共享 Data 类的成员方法.

        4. 对堆内存中 Data 类的对象的所有成员变量进行默认初始化:

               由于 Data 类中的成员变量 data 为 String 类型, 即引用类型, 因此它的默认初始化值为 null.

        5. 如果 Data 类的成员变量在定义时就进行了初始化 (通过赋值运算符 =), 那么根据定义语句给定的初始值进行初始化,
           这一步被称为显式初始化.

        6. 调用 new 关键字右侧指定的 Data 类的构造方法, 这一步被称为构造方法初始化.

               由于这时 new 关键字右侧的 Data 类的构造函数没有参数, 因此虚拟机会调用无参构造函数.

        7. 将堆内存中的 Data 类的对象的地址赋值给引用类型变量 dataObj.
        */


        // 引用类型的变量 dataObj 中存储了堆内存中真实的 Data 类的对象的地址
        System.out.println(dataObj);

        // 通过变量 dataObj 中的地址, 找到堆内存中实际的 Data 类对象, 并且找到该对象中存储的成员变量 data 的值
        System.out.println(dataObj.data);

        /*
        1. 通过变量 dataObj 中的地址, 找到堆内存中保存的成员方法 showData 的地址.

        2. 在方法区中临时存储的 Data 类的字节码文件 Data.class 中找到成员方法 showData 的字节码.

        3. 创建成员方法 showData 的栈帧, 并且将它加载到栈内存中.
        */
        dataObj.showData();
        // 当成员方法 showData 结束后, 该方法的栈帧从栈内存中出栈.
    }
    // 当 main 方法结束后, main 方法的栈帧从栈内存中出栈, 并且栈帧中保存的局部变量 (这里为变量 dataObj) 也会被一同销毁

    // 这时在堆内存中的 Data 类的对象没有被任何 Data 类型的引用类型变量指向, 因此在堆内存中的该对象被垃圾回收
}
