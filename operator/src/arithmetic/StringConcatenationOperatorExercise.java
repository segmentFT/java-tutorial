package arithmetic;

import java.util.Scanner;

public class StringConcatenationOperatorExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputVal = scanner.nextInt();

        System.out.println("units place is: " + (inputVal % 10));
        System.out.println("tens place is: " + ((inputVal / 10) % 10));
        System.out.println("hundreds place is: " + (inputVal / 100));
    }
}
