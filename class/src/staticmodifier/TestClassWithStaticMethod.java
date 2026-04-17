package staticmodifier;

public class TestClassWithStaticMethod {
    public static void main(String[] args) {
        ClassWithStaticMethod obj1 = new ClassWithStaticMethod();

        /*
        由于变量 this 指向调用实例方法 setNonStaticVariable 的对象, 即变量 obj1 指向的对象,
        因此对于被定义为:

            public void setNonStaticVariable(ClassWithStaticMethod this, String nonStaticVariable) {
                System.out.println("the address of caller: " + this);

                this.nonStaticVariable = nonStaticVariable;
            }

        的实例方法 setNonStaticVariable, 通过变量 obj1 调用它, 在语义上类似于:

            setNonStaticVariable(obj1, "for a fake Chinese rubber plant")

        因此在该方法内部输出变量 this 的结果与在 main 方法中直接输出变量 obj1 的结果相同, 即同一个对象的 toString 方法的返回值.
        */
        System.out.println("the address of caller: " + obj1);
        obj1.setNonStaticVariable("for a fake Chinese rubber plant");

        ClassWithStaticMethod obj2 = new ClassWithStaticMethod();

        /*
        同理, 通过变量 obj2 调用实例方法 setNonStaticVariable 的语句：

            obj2.setNonStaticVariable("in the fake plastic earth")

        在语义上类似于:

            setNonStaticVariable(obj2, "in the fake plastic earth")

        因此在该实例方法内部输出变量 this 的结果与在 main 方法中输出变量 obj2 的结果相同.
        */
        System.out.println("the address of caller: " + obj2);
        obj2.setNonStaticVariable("in the fake plastic earth");

        /*
        虚拟机会将实例方法 getNonStaticVariable 的参数 this 存储的地址值传递给被调用的另一个实例方法 display 的参数 this,
        因此在 getNonStaticVariable 和 display 方法中输出的结果是相同的.
        */
        System.out.println(obj1.getNonStaticVariable());
        System.out.println(obj2.getNonStaticVariable());

        ClassWithStaticMethod.staticVariable = "in a town full of rubber plants";
        ClassWithStaticMethod.staticMethod();

        obj1.nonStaticMethod();
        obj2.nonStaticMethod();
    }
}
