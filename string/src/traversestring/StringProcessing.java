package traversestring;

public class StringProcessing {
    public static void main(String[] args) {
        String words = "I'll see you again on the dark side of the moon";

        // String 类的成员方法 substring 用于截取字符串的子串, 并且子串的内容包装为一个新的 String 对象返回

        /*
        substring 方法的重载:

            substring(int beginIndex)

        截取 String 对象中存储的字符串中第 beginIndex 个字符到最后一个字符组成的子串.
        */
        String trimmedWords1 = words.substring(22);

        /*
        substring 方法的重载:

            substring(int beginIndex, int endIndex)

        截取 String 对象中存储的字符串中第 beginIndex 个字符到第 (endIndex - 1) 个字符组成子串.
        */
        String trimmedWords2 = words.substring(5, 18);

        System.out.println(trimmedWords1);
        System.out.println(trimmedWords2);

        //

        /*
        String 类的成员方法 replace 接受两个参数 target 和 replacement,
        该函数将一个 String 类对象存储的字符串中所有与参数 target 相同的子串替换为参数 replacement,
        并且将替换后获得的新字符串包装为一个新的 String 类对象返回, 而原来的 String 类对象不会发生变化.
        */
        String changedWords = words.replace("'ll", " will");

        System.out.println(changedWords);
        System.out.println(words);
    }
}
