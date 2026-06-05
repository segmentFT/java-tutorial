package threadsafety.synchronizedmethod;

class NewRunnable implements Runnable {

    /*
    由于我们使用同一个 NewRunnable 对象构造不同的 Thread 对象, 因此我们创建的不同线程对象调用的是同一个 NewRunnable 对象的 run 方法,
    从而我们不需要将这里的成员变量 numSteps 定义为静态的, 因为它只会被一个 NewRunnable 对象的 run 方法访问.
     */
    private int numSteps = 0;
    private final static int maxNumSteps = 10;

    @Override
    public void run() {
        while (synchronizedMethod()) ;
    }

    /*
    该 synchronized 方法是一个实例方法, 因此用于使得不同的线程对象互斥地执行该方法所用的锁对象, 就是该 synchronized 方法的隐藏的 this 变量
    （位于参数列表的第一个位置）指向的对象, 即调用该实例方法的对象.

    由于我们在通过 NewRunnable 对象构造 Thread 对象时, 可以将同一个 NewRunnable 对象传递给不同 Thread 对象的构造方法,
    因此只需要保证在代码中 NewRunnable 类的实例只会被创建一次, 那么不同的 Thread 对象执行该 synchronized 方法时, 使用的是相同锁对象.
     */
    private synchronized boolean synchronizedMethod() {
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
