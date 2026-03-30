package arithmetic;

import java.util.Scanner;

public class ArithmeticOperatorExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputVal = scanner.nextInt();

        System.out.println(inputVal % 10);
        System.out.println((inputVal / 10) % 10);
        System.out.println(inputVal / 100);
    }
}
