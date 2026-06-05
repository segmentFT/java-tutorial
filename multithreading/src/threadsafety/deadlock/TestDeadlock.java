package threadsafety.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDeadlock {

    public static final Lock lock1 = new ReentrantLock();
    public static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        /*
        假设有两个线程对象 t1 和 t2, 如果存在两个临界区 A 和 B, t1 需要进入 A 并且执行 A 中的语句, 而 t2 需要进入 B 并且执行 B 中的语句.

        同时只有当锁 L1 和 L2 都处于打开状态时, t1 和 t2 才能分别进入 A 和 B. 当 t1 进入 A 后, 它会关闭 L1 和 L2,
        而只有当 t1 离开 A 时, 它才会重新打开 L1 和 L2, 对于 t2 也是同理.

        如果在某个时刻 L1 和 L2 都处于打开状态, 而 t1 关闭了锁 L1, t2 关闭了锁 L2, 那么 t1 无法进入 A, 从而无法在离开 A 时打开 L2,
        同理, t2 也无法进入 B, 从而无法在离开 B 时打开 L1. 因此 t1 等待 t2 释放 L2, 而 t2 等待 t1 释放 L1, 因此出现了死锁.
         */

        Thread t1 = new Thread(
                () -> {
                    final String threadName = Thread.currentThread().getName();

                    lock1.lock();

                    System.out.println(threadName + " has gotten lock 1, then it prepares to get lock 2.");

                    lock2.lock();

                    System.out.println(threadName + " has gotten lock 1 and 2, then it will release them.");

                    lock2.unlock();
                    lock1.unlock();
                },
                "Alice"
        );

        Thread t2 = new Thread(
                () -> {
                    final String threadName = Thread.currentThread().getName();

                    lock2.lock();

                    System.out.println(threadName + " has gotten lock 2, then it prepares to get lock 1.");

                    lock1.lock();

                    System.out.println(threadName + " has gotten lock 1 and 2, then it will release them.");

                    lock1.unlock();
                    lock2.unlock();
                },
                "Bob"
        );

        t1.start();
        t2.start();
    }
}
