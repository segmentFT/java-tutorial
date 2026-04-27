package innerclass.staticinnerclass;

public class Test {
    public static void main(String[] args) {
        OuterClass.StaticInnerClass innerClass = new OuterClass.StaticInnerClass();

        innerClass.instanceData = "instance data";
        OuterClass.StaticInnerClass.staticData = "static data";

        innerClass.instanceMethod();
        OuterClass.StaticInnerClass.staticMethod();
    }
}
