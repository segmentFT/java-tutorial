package membermethodsofclassthread.priority;

public class TestPriorityMemberMethodOfClassThread {
    public static void main(String[] args) {
        /*
        Java 虚拟机使用抢占式的线程调度, 即虚拟机中运行的多个线程抢夺在 CPU 上的执行权, 因此 CPU 执行虚拟机中任意一个线程的时间是不确定的.
        从而在抢占式调度中, 多个线程的执行顺序具有一定的随机性.

        Java 中线程的优先级用一个在 1 到 10 之间的整数表示, 整数的值越大, 表示线程的优先级越高, 对于一个 Thread 类的对象 t,
        可以通过 t 调用 Thread 的实例方法 getPriority 获得 t 的优先级:

            t.getPriority()

        并且可以通过 t 调用 Thread 的实例方法 setPriority 手动设置 t 的优先级:

            t.setPriority(i)

        其中 i 是一个取值在 1 到 10 之间的整数. 如果我们没有为 t 显式地设置优先级, 那么它得到默认优先级的值为 5.

        一个线程对象的优先级越高, 那么它抢占到 CPU 执行权的可能性就越大.
         */

        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++)
                        System.out.println(Thread.currentThread().getName() + " @ turn " + i);
                },
                "Alice"
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++)
                        System.out.println(Thread.currentThread().getName() + " @ turn " + i);
                },
                "Bob"
        );

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}
