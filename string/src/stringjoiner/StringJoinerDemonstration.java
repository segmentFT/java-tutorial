package stringjoiner;

import java.util.StringJoiner;

public class StringJoinerDemonstration {
    public static void main(String[] args) {
        /*
        StringJoiner 类用于将多个字符串使用指定的间隔符将它们拼接, 如果同时制定了前缀字符串 prefix 和后缀字符串 suffix,
        那么 StringJoiner 类的对象还需要将 prefix 和 suffix 分别追加到拼接得到的字符串的开始和末尾.

        StringJoiner 类的对象类似于 StringBuilder 类对象的行为, 其中对象存储的字符串内容可以改变.

        StringJoiner 类没有空参构造函数.
        */

        // 使用带有一个参数的 StringJoiner 类的构造函数, 这时的给定的参数表示拼接字符串时使用的间隔符
        StringJoiner joiner1 = new StringJoiner(" -> ");

        String[] words = {"stranger", "legend", "martyr"};

        for (int i = 0; i < words.length; ++i) {
            // StringJoiner 类的成员方法 add 用于向 StringJoiner 对象中添加需要被拼接的字符串内容
            joiner1.add(words[i]);
        }

        // StringJoiner 类的成员方法 length 返回将多个字符串使用给定的间隔符拼接后得到的字符串的长度 (包含间隔符)
        System.out.println(joiner1.length());

        // StringJoiner 类已经重载了成员方法 toString, 该方法返回 StringJoiner 类的成员属性, 即拼接后获得的字符串内容
        System.out.println(joiner1);

        StringJoiner joiner2 = new StringJoiner(" => ");

        // StringJoiner 类的成员方法 add 返回指向调用它的 StringJoiner 对象的变量, 因此成员方法 add 可以被链式调用
        joiner2.add("painter").add("piper").add("prisoner");

        System.out.println(joiner2);

        /*
        使用待用 3 个参数的 StringJoiner 类的构造函数, 这时给定的参数分别表示:

            被拼接的字符串内容之间的间隔符,
            拼接后的字符串的前缀,
            拼接后的字符串的后缀.
        */
        StringJoiner joiner3 = new StringJoiner(", you ", "Come on you ", ", and shine.");

        joiner3.add("painter").add("piper").add("prisoner");

        System.out.println(joiner3);
    }
}
