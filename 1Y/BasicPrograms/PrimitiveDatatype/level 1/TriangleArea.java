import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double baseCm = input.nextDouble();
        double heightCm = input.nextDouble();

        // area in square centimeters
        double areaSqCm = 0.5 * baseCm * heightCm;

        // convert sq cm to sq inches (1 in = 2.54 cm)
        double areaSqIn = areaSqCm / (2.54 * 2.54);

        System.out.println(
            "The Area of the triangle in sq in is " + areaSqIn +
            " and sq cm is " + areaSqCm
        );
    }
}

