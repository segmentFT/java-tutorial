package innerclass.memberinnerclass;

import java.util.StringJoiner;

public class OuterClass {
    String dataOfOuterClass;

    private class PrivateInnerClass {
        String dataOfPrivateInnerClass;

        public PrivateInnerClass() {}

        public PrivateInnerClass(String dataOfPrivateInnerClass) {
            this.dataOfPrivateInnerClass = dataOfPrivateInnerClass;
        }

        public void display() {
            System.out.println(
                    new StringJoiner("", ">>>", "<<<").add(dataOfPrivateInnerClass).toString()
            );
        }
    }

    public PrivateInnerClass getPrivateInnerClassInstance(String dataOfPrivateInnerClass) {
        return new PrivateInnerClass(dataOfPrivateInnerClass);
    }

    public void displayPrivateInnerClassInfo(String dataOfPrivateInnerClass) {
        PrivateInnerClass innerClass = new PrivateInnerClass(dataOfPrivateInnerClass);

        System.out.println(innerClass.dataOfPrivateInnerClass);
    }
}
