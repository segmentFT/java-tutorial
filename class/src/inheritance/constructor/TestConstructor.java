package inheritance.constructor;

import java.util.StringJoiner;

public class TestConstructor {
    public static void main(String[] args) {
        Test test1 = new Test();

        test1.display();

        System.out.println();

        Test test2 = new Test("In the corner of the morning in the past");

        test2.display();

        System.out.println();

        Test test3 = new Test("I would sit and blame", "the master first and last");

        test3.display();
    }
}

class Test {
    private String data;

    public Test() {
        data = "default";

        System.out.println("constructor without parameters has been called");
    }

    public Test(String data) {
        this();

        this.data = data;

        System.out.println("constructor with parameters has been called");
    }

    public Test(String data1, String data2) {
        this(new StringJoiner(" <--> ").add(data1).add(data2).toString());
    }

    public void display() {
        System.out.println(data);
    }
}
