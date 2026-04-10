package encapsulation;

public class PrivateModifierTest {
    public static void main(String[] args) {
        PrivateModifier obj = new PrivateModifier();

        // PrivateModifier 类的成员变量 data 接受的字符串只能包含数字, 因此对象 obj 的成员变量 data 仍然是初始值 (null)
        obj.setData("And everything under the sun is in tune");

        System.out.println(obj.getData());

        // 该字符串中只包含数字, 因此 setData 函数能够成功地为 obj 的成员变量 data 重新指定值
        obj.setData("1969");

        System.out.println(obj.getData());
    }
}
