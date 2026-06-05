package threadsafety.producerconsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestProducerConsumerProblem {

    public static int consumerCurrentStep = 0;
    public final static int consumerMaxStep = 10;
    public static String data = null;
    public static final Object lock = new Object();

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start();
        consumer.start();
    }
}
