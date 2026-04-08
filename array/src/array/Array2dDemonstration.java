package array;

import java.util.Arrays;

public class Array2dDemonstration {
    public static void main(String[] args) {
        /*
        二维数组的定义和初始化的语句的格式为:

            类型[][] 变量名 = new 类型[][] {{元素1, ..., 元素m}, {元素1, ..., 元素n}, ...}
        */
        String[][] words1 = new String[][] {{"stranger", "legend", "martyr"}, {"painter", "piper", "prisoner"}};

        /*
        二维数组的定义和初始化的语句的简化格式为:

            类型[][] 变量名 = {{元素1, ..., 元素m}, {元素1, ..., 元素n}, ...}

        它等同于:

            类型[][] 变量名 = new 类型[][] {{元素1, ..., 元素m}, {元素1, ..., 元素n}}

        并且构成二维数组的多个一维数组的长度不需要相同.
        */
        String[][] words2 = {
                {"There", "is", "a", "look", "in", "your", "eyes"},
                {"Like", "black", "holes", "in", "the", "sky"},
                {"Shine", "on", "you", "crazy", "diamond"}
        };

        /*
        二维数组中的每个元素都是一个一维数组, 即二维数组的每个元素都是一个引用数据类型的对象.

        因此打印二维数组的元素将会打印出该元素 (一个引用类型的对象) 在栈中的地址值:
            [Ljava.lang.String;@3b6eb2ec
        */
        System.out.println(words1[0]);

        /*
        words1[0]: 二维数组中的第一个一维数组对象.
        words1[0][0]: 通过 [] 运算符获取二维数组中的第一个一维数组对象的第一个元素.
        */
        System.out.println(words1[0][0]);

        /*
        由于二维数组中的每个元素都是一个一维数组对象, 即 words2[i] 是一个一维数组对象, 因此它也具有属性 length
        */
        for (int i = 0; i < words2.length; ++i) {
            for (int j = 0; j < words2[i].length; ++j) {
                System.out.print(words2[i][j] + " ");
            }

            System.out.println();
        }
    }
}
