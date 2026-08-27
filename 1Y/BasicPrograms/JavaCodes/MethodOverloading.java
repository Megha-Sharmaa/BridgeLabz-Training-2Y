public class MethodOverloading {
   
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();

        System.out.println("Two ints: " + obj.add(2, 2));
        System.out.println("Three ints: " + obj.add(2, 2, 3));
        System.out.println("Two doubles: " + obj.add(2.5, 3.5));
    }
}