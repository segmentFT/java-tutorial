package startingmultithreading.thesecondmethod;

/*
启动多线程的第二种方法:
 */
public class SecondMethodToStartMultiThreading {
    public static void main(String[] args) {
        /*
        第一步: 定义一个新的类 A, 使得它实现接口 Runnable.
        第二步: 在 A 的类体中, 重写 Runnable 接口的抽象方法 run.
        第三步: 通过 Thread 类的将 Runnable 接口的实现类对象作为参数的构造方法, 创建一个 Thread 类的对象, 即我们将 A 类的一个实例作为参数,
               传递给 Thread 类的构造方法:

                   Thread t = new Thread(new A())

        第四步: 通过该 Thread 类的实例 t 调用该 Thread 类的成员方法 start, 启动一个线程.
         */
        NewJob newJob = new NewJob();

        Thread newThread1 = new Thread(newJob);
        Thread newThread2 = new Thread(newJob);

        newThread1.setName("thread # 1");
        newThread2.setName("thread # 2");

        newThread1.start();
        newThread2.start();

        /*
        由于 Runnable 接口是一个函数式接口, 因此我们可以向 Thread 类的以 Runnable 接口的实现类对象作为参数的构造函数,
        传入一个 Lambda 表达式:
         */
        Thread newThread3 = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++)
                        System.out.println(Thread.currentThread().getName());
                }
        );

        Thread newThread4 = new Thread(
                () -> {
                    for (int i = 0; i < 100; i++)
                        System.out.println(Thread.currentThread().getName());
                }
        );

        newThread3.setName("thread # 3");
        newThread4.setName("thread # 4");

        newThread3.start();
        newThread4.start();
    }
}
