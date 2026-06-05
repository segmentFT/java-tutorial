package threadsafety.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestBlockingQueue {

    public static void main(String[] args) {
        /*
        Java 中的阻塞队列由 BlockingQueue 接口定义, 它拥有两个实现类:

            ArrayBlockingQueue:

                该类由数组实现, 因此该类的构造函数存在用于指定数组大小的参数, 而该数组的长度也是阻塞队列的长度.

            LinkedBlockingQueue:

                该类由链表实现, 因此由该类实现的阻塞队列在理论上具有无限的长度.

        BlockingQueue 接口中定义了两个抽象方法:

            take 方法:

                假设有一个指向 BlockingQueue 的实现类对象的变量 q, 并且有一个线程对象通过 q 调用了该实现类的实例方法 take:

                    如果 q 指向的阻塞队列为空, 该线程对象就会主动进入阻塞状态.
                    如果 q 指向的阻塞队列不为空, 那么线程对象就会从阻塞队列的队头中取出元素, 同时阻塞队列的队首指针后移.

            put 方法:

                同理, 如果有一个线程对象通过 q 调用了 BlockingQueue 的实现类的实例方法 put:

                    如果 q 指向的阻塞队列为空, 那么该线程对象会向阻塞队列的队尾添入元素, 同时阻塞队列的队尾指针前移.
                    如果 q 指向的阻塞队列已满, 那么该线程对象就会主动进入阻塞状态.

        从而通过 BlockingQueue 接口规定的 take 和 put 方法, 就能够实现生产者和消费者之间的同步.
         */
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        producer.start();
        consumer.start();
    }
}
