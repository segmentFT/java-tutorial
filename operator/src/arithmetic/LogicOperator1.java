package arithmetic;

public class LogicOperator1 {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;

        /*
        短路逻辑运算符 && 的左侧表达式如果能被确定为 false, 那么由 && 连接的整个表达式的值为 false,
        从而 && 的右侧表达式不会被求值.

        因此:
            ++x < 5 && ++y < 5
        中只有表达式 ++x 会被求值, 而表达式 ++y 会被略过, 从而变量 x 和 y 的最终结果分别为 11 和 10.
        */
        boolean result = ++x < 5 && ++y < 5;

        System.out.println(result);
        System.out.println(x);
        System.out.println(y);

        x = 10;
        y = 10;

        /*
        逻辑运算符 & 没有短路效果, 无论运算符 & 的左侧表达式的值为 true 或 false, 运算符 & 的右侧表达式一定会被求值.
        因此:
            ++x < 5 & ++y < 5
        中的表达式 ++x 和 ++y 都会被求值, 从而变量 x 和 y 的最终结果分别为 11 和 11.
        */
        result = ++x < 5 & ++y < 5;

        System.out.println(result);
        System.out.println(x);
        System.out.println(y);
    }
}
