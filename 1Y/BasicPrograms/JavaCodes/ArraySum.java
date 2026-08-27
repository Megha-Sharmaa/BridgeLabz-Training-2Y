public class ArraySum {
    public static void main(String[] args) {
       
        int[] numbers = {10, 20, 30, 40, 50};

        int sum = 0;

       
        for (int num : numbers) {
            sum += num;
        }

        // Print the result
        System.out.println("The sum of the array is: " + sum);
    }
}