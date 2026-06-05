package membermethodsofclassthread.join;

public class TestThreadJoin {
    public static void main(String[] args) {
        /*
        假设有一个线程对象 t1, 我们在它的 run 方法中创建了一个新的线程对象 t2, 如果我们在 t1 的 run 方法中调用 t2 的成员方法 join,
        那么当 t1 执行到 run 方法的语句:

            t2.start();
            t2.join();

        时, t1 会立刻放弃 CPU 的占用, 并且 t2 会获得 CPU 的使用权. 从而直到 t2 执行完它自身的 run 方法后,
        t1 才能接着执行它的 run 方法中在 t2.join() 之后的剩余语句.
         */
        Thread p1 = new Thread(
                () -> {
                    Thread p2 = new Thread(
                            () -> {
                                for (int i = 0; i < 100; i++)
                                    System.out.println(Thread.currentThread().getName() + " @ turn " + i);
                            },
                            "Bob"
                    );

                    p2.start();

                    // 使得 p2 指向的线程对象优先于 p1 指向的线程对象
                    try {
                        p2.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    for (int i = 0; i < 10; i++)
                        System.out.println(Thread.currentThread().getName() + " @ turn " + i);
                },
                "Alice"
        );

        p1.start();
    }
}
