package innerclass.anonymousinnerclass;

public class OuterClass {
    String data;

    public OuterClass() {}

    public OuterClass(String data) {
        this.data = data;
    }

    public void display() {
        AnonymousInnerClassInterface innerClass1 = new AnonymousInnerClassInterface() {
            @Override
            public void display() {
                System.out.print("interface: ");
                System.out.println(OuterClass.this.data);
            }
        };

        innerClass1.display();

        AbstractClass innerClass2 = new AbstractClass() {
            @Override
            public void display() {
                System.out.print("abstract class: ");
                System.out.println(OuterClass.this.data);
            }
        };

        innerClass2.display();
    }
}
