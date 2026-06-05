package threadsafety.lock;

class NewThread extends Thread {

    NewThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 调用互斥锁对象的 lock 方法, 使得该锁被关闭
                TestLock.lock.lock();

                if (TestLock.numSteps >= TestLock.maxNumSteps)
                    break;

                Thread.sleep(1000);

                System.out.println(getName() + " @ turn " + TestLock.numSteps);

                TestLock.numSteps++;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                /*
                由于 finally 代码块中语句一定会被执行, 因此无论是 try 代码块中的语句出现了异常, 还是 try 代码块中的 break 语句被执行,
                从而在线程对象离开该 while 循环前, 互斥锁一定会被打开.
                 */
                TestLock.lock.unlock();
            }
        }
    }
}
