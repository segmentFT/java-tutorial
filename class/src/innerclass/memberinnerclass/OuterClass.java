package innerclass.memberinnerclass;

import java.util.StringJoiner;

public class OuterClass {
    String data;

    public OuterClass() {}

    public OuterClass(String data) {
        this.data = data;
    }

    private class PrivateInnerClass {
        String dataOfPrivateInnerClass;

        public PrivateInnerClass() {}

        public PrivateInnerClass(String dataOfPrivateInnerClass) {
            this.dataOfPrivateInnerClass = dataOfPrivateInnerClass;
        }

        /*
        如果内部类 PrivateInnerClass 在定义时使用修饰符 private 修饰，那么即使在外部类外能够得到 PrivateInnerClass 的实例,
        那么在外部类的外部中，也无法通过该实例访问 PrivateInnerClass 类中的任何成员属性或者方法 (即使使用修饰符 public 修饰).
        */
        public void display() {
            System.out.println(
                    new StringJoiner("", ">>>", "<<<").add(dataOfPrivateInnerClass).toString()
            );
        }
    }

    class PackageAccessInnerClass{
        String dataOfPackageAccessInnerClass;

        public PackageAccessInnerClass() {}

        public PackageAccessInnerClass(String dataOfPackageAccessInnerClass) {
            this.dataOfPackageAccessInnerClass = dataOfPackageAccessInnerClass;
        }
    }

    public class PublicInnerClass {
        String data;

        public PublicInnerClass() {}

        public PublicInnerClass(String data) {
            this.data = data;
        }

        public void display() {
            String data = "airbag";

            System.out.println(data);
            System.out.println(this.data);
            System.out.println(OuterClass.this.data);
        }
    }

    public PrivateInnerClass getPrivateInnerClassInstance(String dataOfPrivateInnerClass) {
        return new PrivateInnerClass(dataOfPrivateInnerClass);
    }

    public void displayPrivateInnerClassInfo(String dataOfPrivateInnerClass) {
        PrivateInnerClass innerClass = new PrivateInnerClass(dataOfPrivateInnerClass);

        innerClass.display();
    }
}
