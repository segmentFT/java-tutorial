package arraylist;

import java.util.ArrayList;

public class WrapperClass {
    public static void main(String[] args) {
        // 基本数据类型 int 对应的包装类为 Integer
        ArrayList<Integer> integers = new ArrayList<>();

        // 在 JDK 5 之后基本数据类型和它对应的包装类之间可以相互转化
        integers.add(1);
        integers.add(2);

        System.out.println(integers);

        // 基本数据类型 char 对应的包装类为 Character
        ArrayList<Character> characters = new ArrayList<>();

        characters.add('h');
        characters.add('o');
        characters.add('r');
        characters.add('i');
        characters.add('z');
        characters.add('o');
        characters.add('n');

        System.out.println(characters);
    }
}
