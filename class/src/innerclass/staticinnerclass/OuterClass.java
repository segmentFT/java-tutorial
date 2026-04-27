package innerclass.staticinnerclass;

import java.util.StringJoiner;

public class OuterClass {
    String data;

    static class StaticInnerClass {
        static String staticData;
        String instanceData;

        static void staticMethod() {
            System.out.println(new StringJoiner("", ">>> ", " <<<").add(staticData));
        }

        void instanceMethod() {
            System.out.println(new StringJoiner("", ">>> ", " <<<").add(instanceData));
        }
    }
}
