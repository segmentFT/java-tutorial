package threadpool.customizedthreadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomizedThreadPool {
    public static void main(String[] args) {
        /*
        Java 中使用 ThreadPoolExecutor 类的对象表示一个线程池, 它的构造函数的参数列表的完整形式为:

            corePoolSize: 表示线程池中核心线程的最大数量, 在线程池中, 核心线程一旦被创建, 那么直到线程池被关闭为止, 核心线程都不会被销毁.
                          参数 corePoolSize 必须是一个正整数.

            maximumPoolSize: 表示线程池中线程的最大数量, 它必须大于等于 corePoolSize, 并且在线程池中,
                             除了核心线程之外的线程也被称为临时线程, 而临时线程的数量为:

                                 maximumPoolSize - corePoolSize ≥ 0

                             与核心线程不同, 在线程池中, 创建的临时线程可能在线程池关闭之前就会被销毁. 如果一个临时线程长时间没有执行任务,
                             即长时间保持空闲状态, 那么它就会被销毁.

            keepAliveTime: 表示临时线程能够保持空闲状态的最大时间, 如果一个临时线程的空闲状态维持超过了 keepAliveTime 的时间,
                           那么该临时线程就会被销毁.

            unit: keepAliveTime 的时间单位, 比如, 秒、分钟或者小时等.

            workQueue: 一个阻塞队列的对象, 如果在线程池的核心线程数量等于 corePoolSize 且没有核心线程空闲的情况下,
                       有一个新的任务被提交给了线程池, 那么该任务就会进入 workQueue 中等待.

                           workQueue 可以是 ArrayBlockingQueue 或者 LinkedBlockingQueue 类型的:

                               如果 workQueue 的类型是 ArrayBlockingQueue:

                                   那么线程池的阻塞队列有一个长度上限.

                                   如果线程池的线程总数（包括核心和临时线程）的小于 maximumPoolSize 且没有线程处于空闲状态,
                                   而这时阻塞队列已满, 那么当一个新的任务被提交给线程池后, 线程池会创建一个新的临时线程用于执行该任务.

                                   如果线程池的线程总数等于 maximumPoolSize 且没有线程处于空闲状态, 而这时阻塞队列已满,
                                   那么线程池就会根据指定的拒绝策略, 进行处理, 要么抛弃该新提交的任务, 要么抛弃阻塞队列中位于队首的任务.

                               如果 workQueue 的类型是 LinkedBlockingQueue:

                                   那么线程池的阻塞队列没有长度上限.

                                   如果线程池的核心线程数量等于 corePoolSize 且没有核心线程处于空闲状态,
                                   那么这时提交给线程池的任务就会进入阻塞队列中等待.

            threadFactory: 一个工厂类的对象. 该对象用于得到一个新的线程对象. 它指定了线程池以怎样的方式创建线程.

            handler: 如果线程池的线程总数等于 maximumPoolSize 且没有线程处于空间状态, 并且阻塞队列已满, 那么这时如果有新的任务提交给线程池,
                     就会触发 handler 指定的拒绝策略.

                     handler 是 ThreadPoolExecutor 类的 4 个静态内部类 AbortPolicy, DiscardPolicy, DiscardOldestPolicy
                     和 CallerRunsPolicy 的实例. 而:

                         如果 handler 是 AbortPolicy 的实例, 那么线程池会直接丢弃新提交的任务, 并且抛出类型为
                         RejectExecutionException 的异常.

                         如果 handler 是 DiscardPolicy 的实例, 那么线程池会直接丢弃新提交的任务, 并且不会抛出异常.

                         如果 handler 是 DiscardOldestPolicy 的实例, 那么线程池会丢弃阻塞队列中位于队首的任务,
                         并且将新提交的任务加入队列.

                         如果 handler 是 CallerRunsPolicy 的实例, 那么线程池会直接调用新提交的任务对象（一个 Runnable 接口的实现类
                         对象）的 run 方法, 从而在线程池本身所处的线程中执行任务, 而不是开启一个新的线程执行任务.


        当有一个新的任务被提交给线程池后, 线程池的工作流程如下:

            如果线程池中核心线程的数量小于 corePoolSize:

                如果存在线程处于空闲状态:

                    那么线程池会让该空闲线程执行该任务.

                如果没有线程处于空闲状态:

                    那么线程池会创建一个新的核心线程用于执行该任务.

            如果线程池中核心线程的数量等于 corePoolSize:

                如果存在线程处于空闲状态:

                    那么线程池会让该空闲线程执行任务.

                如果没有线程处于空闲状态:

                    如果线程池的阻塞队列未满:

                        那么该任务会进入阻塞队列中.

                    如果线程池的阻塞队列已满:

                        如果这时线程池中线程的数量小于 maximumPoolSize:

                            那么线程池会创建一个新的临时线程用于执行该任务.

                        如果这时线程池中线程的数量等于 maximumPoolSize:

                            那么线程池执行它的构造函数的参数 handler 指定的拒绝策略.

        参数 maximumPoolSize 的设定规则:

            对于 CPU 密集型任务:

                maximumPoolSize = 系统中的逻辑处理器数量 + 1

            对于 I/O 密集型任务:

                maximumPoolSize = 系统中的逻辑处理器的数量 × "CPU 的目标利用率" × (("CPU 计算时间" + "I/O 时间") / "CPU 计算时间")
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3, // 核心线程数量, 它必须大于 0
                6, // 最大线程数两, 它必须大于等于核心线程数量
                60, // 空闲的临时线程的最大存活时间
                TimeUnit.SECONDS, // 空闲的临时线程的最大存活时间的时间单位
                new ArrayBlockingQueue<>(3), /* 线程池的用于暂存等待被执行的任务的阻塞队列,
                                                        它是 BlockingQueue 接口的实现类对象
                                                     */
                Executors.defaultThreadFactory(), // 用于创建线程的工厂类的对象
                new ThreadPoolExecutor.AbortPolicy() // 任务的拒绝策略, 它是 ThreadPoolExecutor 类的静态内部类的对象
        );

        // 向线程池提交任务
        pool.submit(
                () -> {
                    for (int i = 0; i < 100; i++)
                        System.out.println("Alice @ turn " + i);
                }
        );

        pool.submit(
                () ->  {
                    for (int i = 0; i < 100; ++i)
                        System.out.println("Bob @ turn " + i);
                }
        );

        // 关闭线程池, 这时线程池中的所有线程对象（核心和临时线程）都会被销毁
        pool.shutdown();
    }
}
