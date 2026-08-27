import java.util.Scanner;

public class RelationalOperators {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        // Relational operations
        System.out.println("number1 > number2  : " + (number1 > number2));
        System.out.println("number1 < number2  : " + (number1 < number2));
        System.out.println("number1 >= number2 : " + (number1 >= number2));
        System.out.println("number1 <= number2 : " + (number1 <= number2));
        System.out.println("number1 == number2 : " + (number1 == number2));
        System.out.println("number1 != number2 : " + (number1 != number2));

        sc.close();
    }
}
