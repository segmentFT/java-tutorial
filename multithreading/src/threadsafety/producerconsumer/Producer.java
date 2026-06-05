package threadsafety.producerconsumer;

import threadsafety.lock.TestLock;

/*
生产者的目的是将产出的数据放入指定的位置. 生产者生产数据的流程如下:

    1. 生产者判断指定的位置是否存在数据:

        如果指定的位置没有数据, 那么调转到 2.

        如果指定的位置已经存在数据, 那么生产生主动等待（进入阻塞状态等待之后被消费者唤醒）.

    2. 生产者将数据存入指定的位置.
    3. 生产者唤醒消费者.
 */
class Producer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (TestProducerConsumerProblem.lock) {
                if (TestProducerConsumerProblem.consumerCurrentStep >= TestProducerConsumerProblem.consumerMaxStep)
                    break;

                if (TestProducerConsumerProblem.data == null) {
                    TestProducerConsumerProblem.data = "data";

                    System.out.print("producer has yielded a new data object @ turn ");
                    System.out.println(TestProducerConsumerProblem.consumerCurrentStep + "");

                    // 我们调用互斥锁的对象的成员方法 notifyAll, 从而唤醒所有绑定到该互斥锁上的线程对象
                    TestProducerConsumerProblem.lock.notifyAll();
                } else {
                    try {
                        // 执行到该语句的线程对象将与该互斥锁对象绑定, 并且该锁被自动打开, 而且当前的线程对象主动进入阻塞状态
                        TestProducerConsumerProblem.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
