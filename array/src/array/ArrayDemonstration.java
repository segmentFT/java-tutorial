package array;

public class ArrayDemonstration {
    public static void main(String[] args) {
        /*
        数组的定义和静态初始化语句的格式为:
            类型[] 数组名 = new 类型[] {元素1, 元素2, ..., 元素n}
        */
        int[] ages1 = new int[] {16, 16, 17, 17};

        /*
        数组的定义和静态初始化的简化格式为:
            类型[] 数组名 = {元素1, 元素2, ..., 元素n}

        它的效果等同于:
            类型[] 数组名 = new 类型[] {元素1, 元素2, ..., 元素n}
        */
        int[] ages2 = {16, 16, 17, 17};

        // 下面的两个数组定于语句是等价的
        String[] names1 = new String[] {"Alice", "Bob", "Charlotte", "Dawis"};
        String[] names2 = {"Alice", "Bob", "Charlotte", "Dawis"};

        /*
        打印数组 ages1 的地址值:
            [I@1e643faf

        其中的:
            '[': 表示地址指向的对象的类型是数组,
            'I': 表示数组中元素的数据类型, ‘I’ 表示 int 类型,
            '@': 分隔符, 分隔开对该地址指向的对象类型的描述和该对象的实际地址值,
            '1e643faf': 对象的地址值, 以十六进制的形式表示.
        */
        System.out.println(ages1);
    }
}
