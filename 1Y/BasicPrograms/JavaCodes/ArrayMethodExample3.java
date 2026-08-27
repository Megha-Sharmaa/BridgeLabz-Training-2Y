import java.util.Scanner;
import java.util.Arrays;

class ArrayMethodExample3 {
    public static void main(String[] args) {
        int[] arr3 = new int[5];

        
        Arrays.fill(arr3, 7);

        System.out.println("Filled Array:");
        System.out.println(Arrays.toString(arr3));
    }
}