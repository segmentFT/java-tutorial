package arithmetic;

import java.util.Scanner;

public class LogicOperatorExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println((x == 6 || y == 6) || ((x + y) % 6 == 0));
    }
}
