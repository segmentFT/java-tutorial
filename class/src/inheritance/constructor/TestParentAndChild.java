package inheritance.constructor;

public class TestParentAndChild {
    public static void main(String[] args) {
        Child child1 = new Child("and I looked and frowned", "and the monster was me");

        child1.display();

        Child child2 = new Child("so I asked a simple black bird");

        child2.display();
    }
}

class Parent {
    private String data;

    public Parent() {}

    public Parent(String data) {
        System.out.println("constructor in parent has been called");

        this.data = data;
    }

    public String getData() {
        return data;
    }
}

class Child extends Parent {
    private String data;

    public Child() {}

    public Child(String dataInParent, String dataInChild) {
        super(dataInParent);

        System.out.println("constructor in child has been called");

        this.data = dataInChild;
    }

    public Child(String data) {
        this(data, data);
    }

    @Override
    public String getData() {
        return data;
    }

    public void display() {
        System.out.println(super.getData());
        System.out.println(this.getData());
    }
}
