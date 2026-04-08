package array;

public class MemoryLayoutOfArray {
    public static void main(String[] args) {
        // 程序的主入口 main 方法的栈帧进入栈中

        int a = 10;
        // 在方法 main 的栈帧中为变量 a 开辟空间, 并且使用常量 10 初始化该空间

        int b = 10;
        // 在方法 main 的栈帧中为变量 b 开辟空间, 并且使用常量 10 初始化该空间

        int c = a + b;
        // 在方法 main 的栈帧中为变量 c 开辟空间, 并且使用表达式 (a + b) 的结果初始化该空间

        System.out.println(c);

        int[] arr = new int[2];
        /*
        在方法 main 的栈帧中为变量 arr 开辟空间, 由于 arr 的类型为 int[], 是一个引用类型,
        因此变量 arr 实际上存储的是地址值, 而该地址指向堆中 int[] 对象占据的内存空间.

        关键字 new 表示在堆中开辟空间, 因此语句:
            new int[2]
        表示在堆中为长度为 2 的 int 类型的数组开辟了新的空间.

        语句:
            int[] arr = new int[2]
        表示将堆中实际的数组对象占据的内存空间的地址值赋值给变量 arr.
        */

        /*
        变量 arr 中存储的内容:
            [I@3b6eb2ec
        是堆中真实的数组对象占据的空间的地址值.
        */
        System.out.println(arr);

        /*
        通过:
            数组地址[数组索引]

        的形式, 可以获取在堆中实际的数组对象中存储的数组元素的值.
        */
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        int[] anotherArr = new int[] {1, 2, 3};

        /*
        变量 anotherArr 中存储的地址值为:
            [I@1e643faf
        不同于变量 arr 中存储的地址值:
            [I@3b6eb2ec

        因此语句:
            new int[] {1, 2, 3}

        在堆中开辟了一块新的内存空间用于存储新的数组对象 int[] {1, 2, 3}.
        */
        System.out.println(anotherArr);

        int[] sameArr = anotherArr;

        /*
        语句:
            int[] sameArr = anotherArr
        将变量 anotherArr 中存储的地址赋值给了 sameArr, 因此这时的变量 sameArr 和 anotherArr 指向了堆中的同一个数组对象.
        */
        System.out.println(sameArr);

        // 对变量 sameArr 和 anotherArr 应用 [] 运算符, 实际上是在对堆中的同一个数组对象进行操作
        for (int i = 0; i < anotherArr.length; i++) {
            System.out.println(anotherArr[i]);
        }

        for (int i = 0; i < sameArr.length; i++) {
            sameArr[i]++;
        }

        for (int i = 0; i < anotherArr.length; i++) {
            System.out.println(anotherArr[i]);
        }
    }
}
