package threadsafety.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

class Producer extends Thread {

    ArrayBlockingQueue<String> blockingQueue;

    Producer(ArrayBlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int itemIndex = 0;

        while (true) {
            String item = "item #" + itemIndex;

            try {
                blockingQueue.put(item);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("producer has yielded " + item);

            itemIndex++;
        }
    }
}
