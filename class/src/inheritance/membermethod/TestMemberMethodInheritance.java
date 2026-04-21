package inheritance.membermethod;

public class TestMemberMethodInheritance {
    public static void main(String[] args) {
        Child child = new Child();

        child.present();
    }
}

class Parent {
    public void display() {
        System.out.println("blood rack");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("barbed wire");
    }

    public void present() {
        super.display();
        this.display();
    }
}
