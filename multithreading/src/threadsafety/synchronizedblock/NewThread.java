package threadsafety.synchronizedblock;

class NewThread extends Thread {

    NewThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            /*
            被 synchronized 关键字包围的代码块被称为同步代码块, 其中的所有语句构成了一个原子操作,
            即, 如果在同步代码块中没有使用 wait() 方法强制阻塞线程, 那么当任意一个线程开始执行 synchronized 代码块中的第一条语句时,
            直到该线程执行到 synchronized 代码块中的最后一条语句, 该线程的执行过程都不会被其他线程打断.

            即 synchronized 代码块保证, 只要一个线程能够进入该代码块, 并且没有主动将自身阻塞（调用 wait() 方法）,
            那么直到该线程将该 synchronized 代码快中的所有语句执行完之前, 其他的线程都不能进入该 synchronized 代码块.

            synchronized 关键字后用 () 包围的表达式可以是任意的一个对象, 即 Object 对象以及 Object 的子类的对象, 该对象作为同步锁.

                当线程进入 synchronized 代码块时, 它首先需要申请锁, 如果锁已经被申请, 那么该线程会在 synchronized 代码块的外部等待,
                直到分配给该线程的 CPU 时间片段被消耗完, CPU 的执行权被分配给其他线程.

                当一个已经进入 synchronized 代码块的线程到达块的末尾后, 该锁会被释放, 从而其它抢占到 CPu 的线程可以申请该锁,
                并进入 synchronized 代码块.

            并且如果一个 synchronized 代码块需要被不同的线程对象互斥地执行,
            那么该 synchronized 代码块的锁对象在这些线程对象的 run 方法中必须是同一个对象.
             */
            synchronized (TestSynchronizedBlock.lock) {
                if (TestSynchronizedBlock.numSteps >= TestSynchronizedBlock.maxNumSteps)
                    break;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(getName() + " @ turn " + TestSynchronizedBlock.numSteps);

                TestSynchronizedBlock.numSteps++;
            }
        }
    }
}
