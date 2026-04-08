package array;

public class DynamicArray2dInitialization {
    public static void main(String[] args) {
        /*
        不进行初始化的二维数组的定义语句的格式为:

            类型[][] 变量名 = new 类型[m][n]

        其中的 m 是二维数组中一维数组的数量, 而 n 是二维数组中每个一维数组的元素的数量.
        */
        String[][] words = new String[3][5];

        // String 是引用数据类型, 因此二维数组中每个一维数组的每个元素的默认初始化值为 null
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length; ++j) {
                System.out.print(words[i][j] + " ");
            }

            System.out.println();
        }

        // 整数类型 (包括 byte, short, int, long) 的二维数组中每个一维数组的每个元素的默认初始化值为 0
        int[][] integers = new int[4][4];

        for (int i = 0; i < integers.length; ++i) {
            for (int j = 0; j < integers[i].length; ++j) {
                System.out.print(integers[i][j] + " ");
            }

            System.out.println();
        }

        // 浮点数类型 (包括 float, double) 的二维数组中的每个一维数组的每个元素的默认初始化值为 0.0
        double[][] decimals = new double[4][4];

        for (int i = 0; i < decimals.length; ++i) {
            for (int j = 0; j < decimals[i].length; ++j) {
                System.out.print(decimals[i][j] + " ");
            }

            System.out.println();
        }

        // 字符类型的二维数组中的每个一维数组的每个元素的默认初始化值为 unicode 码 '\u0000'
        char[][] characters = new char[4][4];

        for (int i = 0; i < characters.length; ++i) {
            for (int j = 0; j < characters[i].length; ++j) {
                System.out.print(characters[i][j] + " ");
            }

            System.out.println();
        }

        // 布尔类型的二维数组中的每个一维数组的每个元素的默认初始化值为 false
        boolean[][] truthValues = new boolean[4][4];

        for (int i = 0; i < truthValues.length; ++i) {
            for (int j = 0; j < truthValues[i].length; ++j) {
                System.out.print(truthValues[i][j] + " ");
            }

            System.out.println();
        }

        /*
        不进行初始化且不创建一维数组的二维数组的定义语句的格式为:

            类型[][] 变量名 = new 类型[m][]

        其中变量名存储一个地址值, 它指向内存中的一个长度为 m 的数组对象, 该对象中的每个元素的类型为 '类型[]',
        因此这相当于创建了一个数组, 其中数组中的每个元素保存指向一个一维数组对象的地址值.
        */
        String[][] anotherWords = new String[3][];

        String[] wordsLine1 = {"Remember", "when", "you", "were", "young"};
        String[] wordsLine2 = {"You", "shine", "like", "the", "sun"};
        String[] wordsLine3 = {"Shine", "on", "you", "crazy", "diamond"};

        // 可以为变量 anotherWords 指向的数组对象中的每个元素指定它们指向的一维数组对象
        anotherWords[0] = wordsLine1;
        anotherWords[1] = wordsLine2;
        anotherWords[2] = wordsLine3;

        for (int i = 0; i < anotherWords.length; ++i) {
            for (int j = 0; j < anotherWords[i].length; ++j) {
                System.out.print(anotherWords[i][j] + " ");
            }

            System.out.println();
        }

        String[] newWordsLine1 = {"Threatened", "by", "shadows", "at", "night"};
        String[] newWordsLine2 = {"And", "exposed", "in", "the", "light"};

        // 变量 anotherWords 指向的数组对象中的元素的指向可以改变, 即它们可以被赋予新的地址值
        anotherWords[0] = newWordsLine1;
        anotherWords[1] = newWordsLine2;

        for (int i = 0; i < anotherWords.length; ++i) {
            for (int j = 0; j < anotherWords[i].length; ++j) {
                System.out.print(anotherWords[i][j] + " ");
            }

            System.out.println();
        }
    }
}
