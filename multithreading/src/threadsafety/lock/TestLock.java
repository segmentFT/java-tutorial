package threadsafety.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    /*
    Lock 是一个接口, 它表示一个互斥锁, ReentrantLock 类是 Lock 接口的一个实现类, 在 synchronized 代码块和 synchronized 方法中,
    对互斥锁的对象的关闭和释放的操作都是由 Java 虚拟机自动完成的, 通过 Lock 的实现类对象, 我们可以手动地关闭或者释放一个互斥锁的对象.

    如果需要保证多个线程互斥的执行一段代码, 那么我们需要:

        在代码区的入口位置关闭互斥锁.

        在代码区的出口位置释放互斥锁.

    因为任何一个线程对象要进入该代码区, 该代码区的互斥锁必须处于打开的状态, 否则该线程对象就会在该代码区的入口位置等待,
    当一个线程对象要离开该代码区时, 必须要释放互斥锁, 从而让其他的线程对象有机会进入该代码区.

    并且如果我们要让多个线程对象互斥地进入一个代码区, 那么我们要确保这些线程对象在该代码区的入口和出口位置操作的互斥锁是同一个对象.
     */
    public static Lock lock = new ReentrantLock();

    public static int numSteps = 0;

    public final static int maxNumSteps = 10;

    public static void main(String[] args) {
        NewThread t1 = new NewThread("Alice");
        NewThread t2 = new NewThread("Bob");

        t1.start();
        t2.start();
    }
}
