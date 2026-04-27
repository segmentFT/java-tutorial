package innerclass.localinnerclass;

public class OuterClass {
    String data;

    public OuterClass() {}

    public OuterClass(String data) {
        this.data = data;
    }

    public void display(String data) {
        String prefix = ">>> ";
        String suffix = " <<<";

        class LocalInnerClass {
            String data;

            public LocalInnerClass() {}

            public LocalInnerClass(String data) {
                this.data = data;
            }

            public void display() {
                System.out.println(OuterClass.this.data);
                System.out.println(prefix + this.data + suffix);
            }
        }

        LocalInnerClass innerClass = new LocalInnerClass(data);

        innerClass.display();
    }
}
