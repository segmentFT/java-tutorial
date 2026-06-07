package threadpool.utilityclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        /*
        可以通过工具类中的静态方法 newCachedThreadPool 和 newFixedThreadPool 创建线程池对象, 它们返回一个类型为 ExecutorService
        的引用, 其中 ExecutorService 是一个接口, Java 中所有的线程池的具体类都实现了该接口.

            newCachedThreadPool 用于创建一个包含的线程对象数量没有上限的线程池.

            newFixedThreadPool 用于创建一个包含的线程对象数量的上限由它的参数 nThreads 指定的的线程池.
         */
        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.submit(
                () -> {
                    for (int i = 0; i < 100; i++)
                        System.out.println("Alice @ turn " + i);
                }
        );

        pool.submit(
                () -> {
                    for (int i = 0; i < 100; i++)
                        System.out.println("Bob @ turn " + i);
                }
        );

        pool.shutdown();
    }
}
