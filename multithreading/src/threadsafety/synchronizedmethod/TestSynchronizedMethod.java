package threadsafety.synchronizedmethod;

public class TestSynchronizedMethod {

    public static int numSteps = 0;

    public final static int maxNumSteps = 10;

    public static void main(String[] args) {
        Thread t1 = new Thread(
                () -> {
                    while (synchronizedMethod()) ;
                },
                "Alice"
        );

        Thread t2 = new Thread(
                () -> {
                    while (synchronizedMethod()) ;
                },
                "Bob"
        );

        t1.start();
        t2.start();

        NewRunnable job = new NewRunnable();

        Thread t3 = new Thread(job, "Charlie");
        Thread t4 = new Thread(job, "David");

        t3.start();
        t4.start();
    }

    /*
    如果一个方法的定义中, 方法被修饰符 synchronized 修饰, 那么我们将该方法称为同步方法.

    如果在该方法中没有使用 wait() 方法手动阻塞线程, 那么该方法的方法体中的所有语句构成了一个原子操作,
    从而只要一个线程对象进入该 synchronized 方法的方法体, 那么在该线程对象执行完到该 synchronized 方法的方法体之前,
    其他的线程对象都不能进入该 synchronized 方法的方法体.

    和 synchronized 代码块相同, synchronized 方法也是通过锁对象实现不同的线程对象互斥地执行一个方法, 但是该锁对象是虚拟机指定的:

        如果该 synchronized 方法是一个静态方法, 那么锁对象是该静态方法所属的类的字节码文件对象.

        如果该 synchronized 方法是一个实例方法, 那么锁对象是该实例方法的 this 变量（隐式地位于方法的第一个参数的位置）指向的对象.
     */
    public synchronized static boolean synchronizedMethod() {
        if (numSteps >= maxNumSteps)
            return false;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " @ turn " + numSteps);

        numSteps++;

        return true;
    }
}
