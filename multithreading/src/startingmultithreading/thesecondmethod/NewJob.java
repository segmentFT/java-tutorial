package startingmultithreading.thesecondmethod;

class NewJob implements Runnable {
    @Override
    public void run() {
        /*
        假设当前在程序的进程中执行 run 方法的线程实例是 t, 由于 Java 中使用 Thread 类实现线程, 因此 t 是一个 Thread 类的实例.
        那么 Thread 类的静态方法 currentThread 将会返回一个指向 t 的引用.
         */
        Thread currentThread = Thread.currentThread();

        for (int i = 0; i < 100; i++)
            // 输出当前执行 run 方法的线程对象的属性 name 的值
            System.out.println(currentThread.getName());
    }
}
