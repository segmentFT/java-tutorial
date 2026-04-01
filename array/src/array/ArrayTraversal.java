package array;

public class ArrayTraversal {
    public static void main(String[] args) {
        String[] words = {"Wish", "you", "were", "here"};

        // 任何数组对象都具有属性 length, 记录了该数组的长度
        System.out.println(words.length);

        // 标准的基于 for 循环的数组遍历
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}
