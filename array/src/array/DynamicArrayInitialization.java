package array;

public class DynamicArrayInitialization {
    public static void main(String[] args) {
        /*
        不进行初始化的数组定义语句的格式为:
            类型[] 数组名 = new 类型[数组长度]

        其中定义后的数组中元素的初始值由虚拟机给定.
        */
        String[] words = new String[4];

        // String 类型的数组的默认初始化值为空 (null), 因为 String 是一个引用数据类型
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        // int 类型 (包括 byte, short, long) 的数组的元素的默认初始化值为 0
        int[] integers = new int[4];

        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i]);
        }

        // double 类型 (包括 float) 的数组的元素的默认初始化值为 0.0
        double[] decimals = new double[4];

        for (int i = 0; i < decimals.length; i++) {
            System.out.println(decimals[i]);
        }

        // char 类型的数组的元素的默认初始化值为 unicode 码 '\u0000'
        char[] characters = new char[4];

        for (int i = 0; i < characters.length; i++) {
            System.out.println(characters[i]);
        }

        // bool 类型的数组的元素的默认初始化值为 false
        boolean[] truthValues = new boolean[4];

        for (int i = 0; i < truthValues.length; i++) {
            System.out.println(truthValues[i]);
        }
    }
}
