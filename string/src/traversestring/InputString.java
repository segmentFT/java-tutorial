package traversestring;

import java.util.Scanner;

public class InputString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Scanner 类的成员方法 next 在堆内存上创建 String 类型对象, 并由虚拟机将该对象的地址值赋值给 s1
        String s1 = sc.next();

        System.out.println(s1);

        // String 类的成员方法 charAt 可以根据作为下标的参数, 返回 String 类对象存储的字符串中指定位置的字符
        // String 类的成员方法 length 返回 String 类对象存储的字符串的长度
        for (int i = 0; i < s1.length(); ++i)
            System.out.println(s1.charAt(i));
    }
}
