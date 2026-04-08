package methodoverload;

public class MethodOverload {
    public static void main(String[] args) {
        byte x1 = 127;
        short x2 = 128;
        int x3 = 127;
        long x4 = 128;

        System.out.println(compare(x1, x1));
        System.out.println(compare(x1, x2));
        System.out.println(compare(x1, x3));
        System.out.println(compare(x1, x4));
        System.out.println(compare(x2, x1));
        System.out.println(compare(x2, x2));
        System.out.println(compare(x2, x3));
        System.out.println(compare(x2, x4));
        System.out.println(compare(x3, x1));
        System.out.println(compare(x3, x2));
        System.out.println(compare(x3, x3));
        System.out.println(compare(x3, x4));
        System.out.println(compare(x4, x1));
        System.out.println(compare(x4, x2));
        System.out.println(compare(x4, x3));
        System.out.println(compare(x4, x4));
    }

    public static boolean compare(byte x1, byte x2) {
        // 当 byte 类型的变量参与比较运算时, 它们首先会被隐式地的提升为 int 类型
        return x1 == x2;
    }

    public static boolean compare(byte x1, short x2) {
        // 当 short 类型的变量参与比较运算时, 它们首先会被隐式地提升为 int 类型
        return x1 == x2;
    }

    public static boolean compare(byte x1, int x2) {
        return x1 == x2;
    }

    public static boolean compare(byte x1, long x2) {
        // byte 类型的变量首先会被隐式地提升为 int 类型, 之后再被提升为 long 类型, 从而保持运算符左右两侧的操作数类型一致
        return x1 == x2;
    }

    public static boolean compare(short x1, byte x2) {
        return x1 == x2;
    }

    public static boolean compare(short x1, short x2) {
        return x1 == x2;
    }

    public static boolean compare(short x1, int x2) {
        return x1 == x2;
    }

    public static boolean compare(short x1, long x2) {
        return x1 == x2;
    }

    public static boolean compare(int x1, byte x2) {
        return x1 == x2;
    }

    public static boolean compare(int x1, short x2) {
        return x1 == x2;
    }

    public static boolean compare(int x1, int x2) {
        return x1 == x2;
    }

    public static boolean compare(int x1, long x2) {
        return x1 == x2;
    }

    public static boolean compare(long x1, byte x2) {
        return x1 == x2;
    }

    public static boolean compare(long x1, short x2) {
        return x1 == x2;
    }

    public static boolean compare(long x1, int x2) {
        return x1 == x2;
    }

    public static boolean compare(long x1, long x2) {
        return x1 == x2;
    }
}
