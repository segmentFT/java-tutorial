package encapsulation;

public class VariableScopeTest {
    public static void main(String[] args) {
        VariableScope obj = new VariableScope();

        obj.methodWithoutThisPointer("Speak To Me");

        System.out.println(obj.getData());

        obj.methodWithThisPointer("On The Run");

        System.out.println(obj.getData());
    }
}
