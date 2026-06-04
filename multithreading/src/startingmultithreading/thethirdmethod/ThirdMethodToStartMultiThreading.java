package startingmultithreading.thethirdmethod;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
启动多线程的第三种方法:
 */
public class ThirdMethodToStartMultiThreading {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        Callable 类以及作为它的实现类的 Thread 类中的 run 方法没有返回值, 为了能够让线程执行一个具有返回值的方法,
        并且在线程结束后能够获得该方法的返回值, 我们需要使用 Callable 和 Future 接口.

        第一步: 定义一个新的类 A, 使得它实现 Callable 接口.
        第二步: 在 A 的类体中重写 Callable 接口中的抽象方法 call, 并且 Callable 接口是一个泛型接口,
               为该接口的形式泛型参数 T 指定的实际具体类型 B, 就是 call 方法的返回值的类型.

        第三步: 创建一个 A 的实例 a.
        第四步: 使用 Future 接口的实现类 FutureTask 的以 Callable 接口的实现类对象作为参数的构造函数, 创建一个 FutureTask 类的实例,
               即, 我们将 a 作为参数传入给 FutureTask 类的构造函数:

                   FutureTask task = new FutureTask(new A())

        第五步: 由于 FutureTask 类同时是 Runnable 接口的实现类, 我们使用 Thread 类的以 Runnable 接口作为参数的构造函数,
               创建一个 Thread 类的实例. 即, 我们将 task 作为参数传入给 Thread 类的构造函数:

                   Thread t = new Thread(task)

               在通过 t 调用 Thread 类的实例方法 start, 启动一个线程, 执行 A 中的 call 方法.

        第六步: 当 t 指向的线程实例终止后, 我们通过 task 调用 FutureTask 的实例方法 get, 获得 A 中的 call 方法的返回值.
         */

        CallableObject callableObj = new CallableObject();

        FutureTask<Integer> task1 = new FutureTask<>(callableObj);

        Thread t1 = new Thread(task1);

        t1.start();

        System.out.println(task1.get());

        /*
        由于 Callable 对象是一个函数式接口, 因此我们可以使用 Lambda 表达式作为 FutureTask 的构造函数的参数:
         */
        FutureTask<Integer> task2 = new FutureTask<>(
                () -> {
                    int result = 0;

                    for (int i = 1; i <= 10; i++)
                        result += i;

                    return result;
                }
        );

        Thread t2 = new Thread(task2);

        t2.start();

        System.out.println(task2.get());
    }
}
