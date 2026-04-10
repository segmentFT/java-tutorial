package encapsulation;

public class VariableScope {
    private String data;

    public void methodWithoutThisPointer(String data) {
        /*
        由于在 Java 中, 方法的局部变量的作用域会覆盖类的成员变量的作用域,
        那么由于方法的形式参数 data 属于方法的局部变量, 从而它的作用域会覆盖类的同名的成员变量 data 的作用域,
        因此, 语句:

            data = data

        等价于将引用类型的局部变量 data 存储的地址值重新赋值给它自己, 从而与类的成员变量 data 无关,
        因此类的成员变量 data 仍然保持默认值 (即 null).
        */
        data = data;
    }

    public void methodWithThisPointer(String data) {
        /*
        通过 this 关键字可以强制访问类的成员变量, 从而避免方法中同名的局部变量的作用域覆盖类的成员变量的作用域.

        this 关键字实际上表示调用方法 methodWithThisPointer 的 VariableScope 类的对象的地址值 (在堆内存中),
        即调用当前方法的对象在堆内存中的地址值.
        */
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
