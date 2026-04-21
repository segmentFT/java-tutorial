package inheritance.membervariable;

public class TestMemberVariableInheritance {
    public static void main(String[] args) {
        Child child = new Child();

        child.display();
    }
}

class Ancestor {
    String dataInAncestor = "at paranoia's poison door";
}

class Parent extends Ancestor {
    String data = "neurosurgeons scream for more";
}

class Child extends Parent {
    String data = "iron claw";

    public void display() {
        String data = "cat's foot";

        System.out.println(data);
        System.out.println(this.data);
        System.out.println(super.data);
        System.out.println(super.dataInAncestor);
    }
}
