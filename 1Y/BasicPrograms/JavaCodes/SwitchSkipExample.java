
public class SwitchSkipExample {
    public static void main(String[] args) {
        int number = 3;  // Try changing this value (1–5)

        switch (number) {
            case 1:
                System.out.println("Number is One");
                break;
            case 2:
                System.out.println("Number is Two");
                break;
            // case 3 is intentionally skipped
            case 4:
                System.out.println("Number is Four");
                break;
            case 5:
                System.out.println("Number is Five");
                break;
            default:
                System.out.println("Number not in range or skipped");
        }
    }
}