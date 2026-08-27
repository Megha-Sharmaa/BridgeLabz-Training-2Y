import java.util.Scanner;

public class FloatOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float a = input.nextFloat();
        float b = input.nextFloat();
        float c = input.nextFloat();

        float r1 = a + b * c;
        float r2 = a * b + c;
        float r3 = c + a / b;
        float r4 = a % b + c;

        System.out.println(
            "The results of Float Operations are " +
            r1 + ", " + r2 + ", " + r3 + " and " + r4
        );
    }
}
