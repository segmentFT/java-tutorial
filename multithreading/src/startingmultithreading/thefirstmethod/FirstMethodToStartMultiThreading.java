package startingmultithreading.thefirstmethod;

/*
启动多线程的第一种方法:
 */
public class FirstMethodToStartMultiThreading {
    public static void main(String[] args) {
        /*
        一个 Thread 类或者它的子类的实例就是虚拟机中的一个线程的实例.

        第一步: 定义一个新的类 A, 使得它继承 Thread 类.
        第二步: 在 A 的类体中重写 Thread 类的成员方法 run.
        第三步: 创建一个 A 类的对象 a, 并且通过 a 调用 A 的实例方法 start, 启动一个线程.
         */
        NewThread newThread1 = new NewThread();
        NewThread newThread2 = new NewThread();

        /*
        通过调用 Thread 类的成员方法 setName, 可以修改 Thread 的成员变量 name 的值,
        并且可以通过 a 调用 Thread 类的成员方法 getName, 获得该属性 name 的值.
         */
        newThread1.setName("thread # 1");
        newThread2.setName("thread # 2");

        newThread1.start();
        newThread2.start();
    }
}
