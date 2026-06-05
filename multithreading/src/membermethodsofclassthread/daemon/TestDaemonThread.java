package membermethodsofclassthread.daemon;

public class TestDaemonThread {
    public static void main(String[] args) {
        /*
        假设有多个线程对象:

            t(1), ..., t(M), t(M + 1), ..., t(N)

        其中 t(1), ..., t(M) 是非守护线程, 而 t(M + 1), ..., t(N) 是守护线程. 那么只要 t(1), ..., t(M) 全部终止,
        即这些线程对象全部执行到了它们各自的 run 方法的方法体的末尾,
        那么即使 t(M + 1), ..., t(N) 中存在线程对象还没有执行完它的 run 方法的方法体, 所有的 t(M + 1), ..., t(N) 也会被终止,
        由于线程通讯延迟, 因此当 t(1), ..., t(M) 全部结束后, t(M + 1), ..., t(N) 中的还没有结束的线程对象可能在一段时间之后才会被终止,
        在这一段时间中, t(M + 1), ..., t(N) 中还没有结束的线程对象会继续执行它们各自的 run 方法.

        即, 只要非守护线程结束, 那么所有的守护线程也必须结束.
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
                    for (int i = 0; i < 100; i++)
                        System.out.println(Thread.currentThread().getName() + " @ turn " + i);
                },
                "Bob"
        );

        // 调用 Thread 对象的实例方法 setDaemon 可以将该 Thread 对象设置为守护线程
        t2.setDaemon(true);

        /*
        t1 和 t2 指向的线程对象分别是非守护线程和守护线程, 其中 t1 指向的 Thread 对象中的 run 方法中有 10 条输出语句,
        而 t2 指向的 Thread 对象中的 run 方法中有 100 条输出语句.

        如果 t2 指向的 Thread 对象不是守护线程, 那么最终在屏幕上会有 110 条输出, 但是由于 t2 指向的 Thread 对象是守护线程,
        因此最终屏幕上的输出远少于 110 条, 因为 t1 指向的 Thread 对象的 run 方法中输出语句数量更少, 因此 t1 指向的对象一定会先结束,
        而只要 t1 指向的对象结束, 那么即使 t2 指向的对象还没有执行完它的 run 方法, t2 指向的对象也会随之结束.
        从而 t2 指向的 Thread 对象通常无法完整的执行它的 run 方法中的 100 条输出语句.
         */
        t1.start();
        t2.start();
    }
}
