package polymorphism;

import java.util.StringJoiner;

public class TestPolymorphism {
    public static void main(String[] args) {
        Parent parent = new Child();

        parent.display();

        Child child = (Child) parent;

        child.data = "default";
        child.present();
    }
}

class Parent {
    String data;

    public Parent() {}

    public Parent(String data) {
        this.data = data;
    }

    public void display() {
        System.out.println("display in parent");
    }
}

class Child extends Parent {
    String data;

    public Child() {}

    public Child(String dataInChild, String dataInParent) {
        super(dataInParent);

        this.data = dataInChild;
    }

    @Override
    public void display() {
        System.out.println("display in child");
    }

    public void present() {
        System.out.println(new StringJoiner("", ">>>", "<<<").add(this.data).toString());
    }
}
