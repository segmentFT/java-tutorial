package threadsafety.producerconsumer;

/*
消费者的目的是从指定的位置读取数据. 消费者读取数据的流程如下:

    1. 消费者判断指定的位置是否存在数据:

        如果指定的位置没有数据, 那么消费者主动等待（进入阻塞状态, 等待之后被生产者唤醒）.

        如果指定的位置存在数据, 那么跳转到 2.

    2. 消费者从指定的位置取出数据.
    3. 消费者唤醒生产者.
 */
class Consumer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (TestProducerConsumerProblem.lock) {
                if (TestProducerConsumerProblem.consumerCurrentStep >= TestProducerConsumerProblem.consumerMaxStep)
                    break;

                if (TestProducerConsumerProblem.data == null) {
                    try {
                        /*
                        执行到该语句:

                            lock.wait()

                        的线程对象将会被绑定到 lock 指向的互斥锁的对象上, 并且该互斥锁会被自动打开, 而且该线程对象会主动进入阻塞状态.
                        */
                        TestProducerConsumerProblem.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    TestProducerConsumerProblem.data = null;

                    System.out.print("consumer has received a data object @ turn ");
                    System.out.println(TestProducerConsumerProblem.consumerCurrentStep + "");

                    TestProducerConsumerProblem.consumerCurrentStep++;

                    // 唤醒所有绑定到该互斥锁的处于阻塞状态的线程对象
                    TestProducerConsumerProblem.lock.notifyAll();
                }
            }
        }
    }
}
