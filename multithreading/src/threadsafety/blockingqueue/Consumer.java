package threadsafety.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

class Consumer extends Thread {

    ArrayBlockingQueue<String> blockingQueue;

    Consumer(ArrayBlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String item = blockingQueue.take();

                System.out.println("consumer has received " + item);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
