package membermethodsofclassthread.yield;

public class TestYieldThread {
    public static void main(String[] args) {
        /*
        当一个线程对象执行的 run 方法中的方法体存在语句:

            Thread.yield()

        后, 即使在 run 方法中该语句之后仍有语句没有被执行, 该对象也会立刻放弃对 CPU 的占用, 之后虚拟机中的所有线程再次重新抢夺 CPU 的控制权.

        其中 yield 方法是 Thread 类的一个静态方法.
         */
        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++)
                        System.out.println(Thread.currentThread().getName() + " @ turn " + i);

                    Thread.yield();
                },
                "Alice"
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++)
                        System.out.println(Thread.currentThread().getName() + " @ turn " + i);

                    Thread.yield();
                },
                "Bob"
        );

        t1.start();
        t2.start();
    }
}
