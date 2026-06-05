package threadsafety.synchronizedblock;

public class TestSynchronizedBlock {

    public static int numSteps = 0;

    public final static int maxNumSteps = 10;

    public final static Object lock = new Object();

    public static void main(String[] args) {
        NewThread t1 = new NewThread("Alice");
        NewThread t2 = new NewThread("Bob");

        t1.start();
        t2.start();
    }
}
