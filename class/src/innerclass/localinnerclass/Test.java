package innerclass.localinnerclass;

public class Test {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("outer data");

        outerClass.display("inner data");
    }
}
