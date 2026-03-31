package arithmetic;

public class AssignmentOperator {
    public static void main(String[] args) {
        short x = 1;

        //
        /*
        复合赋值运算符会自动进行强制类型转换. 由于 x += 1 等价于:
            x = x + 1
        short 类型的值在进行运算时会被隐式地提升为 int 类型, 因此:
            x + 1
        是一个 int 类型的表达式. 为了将该表达式的值赋值给 short 类型的变量 x, 它需要被强制转换为 short 类型:
            (short)(x + 1)
        因此 x += 1 隐式地等价于:
            x = (short)(x + 1)

        复合赋值运算符的自动强制类型转换的目标类型是左值的类型
        */
        x += 1;

        System.out.println(x);
    }
}
