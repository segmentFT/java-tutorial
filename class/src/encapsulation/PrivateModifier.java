package encapsulation;

/*
在类中被 private 修饰符修饰的成员变量只能被该类的成员方法 (类的行为) 访问,
而不能在其他的类的成员方法中 (比如测试类的 main 方法中) 被直接访问.
*/

public class PrivateModifier {
    private String data;
    /*
    类需要为被 private 修饰符修饰的成员变量提供对应的 set 和 get 方法,
    set 和 get 方法都必须被 public 修饰符修饰, 从而它们可以在其他的类的成员方法中被访问.
    */

    // set 方法用于给对应的成员变量赋值, 并且可以在 set 方法中对输入参数进行校验, 判断它是否符合要求
    public void setData(String newData) {
        for (int i = 0; i < newData.length(); ++i) {
            if (newData.charAt(i) < '0' || newData.charAt(i) > '9') {
                System.out.println("invalid data");

                return;
            }
        }

        data = newData;
    }

    // get 方法用于获取对应的成员变量的值, 并且将它作为自身的返回值
    public String getData() {
        return data;
    }
}
