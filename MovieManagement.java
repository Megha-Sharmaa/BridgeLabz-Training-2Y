
import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;

    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagement {

    static Movie head = null;
    static Movie tail = null;

    static Scanner sc = new Scanner(System.in);

    // Add movie at beginning
    static void insertBeginning() {

        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Director: ");
        String director = sc.nextLine();

        System.out.print("Enter Year of Release: ");
        int year = sc.nextInt();

        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();

        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println("Movie added successfully!");
    }

    // Add movie at end
    static void insertEnd() {

        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Director: ");
        String director = sc.nextLine();

        System.out.print("Enter Year of Release: ");
        int year = sc.nextInt();

        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();

        Movie newNode = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Movie added successfully!");
    }

    // Add movie at specific position
    static void insertPosition() {

        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        sc.nextLine();

        if (pos < 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Movie temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Director: ");
        String director = sc.nextLine();

        System.out.print("Enter Year of Release: ");
        int year = sc.nextInt();

        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();

        Movie newNode = new Movie(title, director, year, rating);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;

        System.out.println("Movie added successfully!");
    }

    // Remove movie by title
    static void removeMovie() {

        System.out.print("Enter Movie Title to Remove: ");
        String title = sc.nextLine();

        Movie temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                if (temp == head) {
                    head = temp.next;
                } else {
                    temp.prev.next = temp.next;
                }

                if (temp == tail) {
                    tail = temp.prev;
                } else {
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found!");
    }

    // Search movie by director
    static void searchDirector() {

        System.out.print("Enter Director Name: ");
        String director = sc.nextLine();

        Movie temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.director.equalsIgnoreCase(director)) {

                System.out.println("\nMovie Found!");
                System.out.println("Title: " + temp.title);
                System.out.println("Director: " + temp.director);
                System.out.println("Year: " + temp.year);
                System.out.println("Rating: " + temp.rating);

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Movie not found!");
        }
    }

    // Search movie by rating
    static void searchRating() {

        System.out.print("Enter Rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();

        Movie temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.rating == rating) {

                System.out.println("\nMovie Found!");
                System.out.println("Title: " + temp.title);
                System.out.println("Director: " + temp.director);
                System.out.println("Year: " + temp.year);
                System.out.println("Rating: " + temp.rating);

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Movie not found!");
        }
    }

    // Display movies in forward order
    static void displayForward() {

        if (head == null) {
            System.out.println("Movie list is empty!");
            return;
        }

        Movie temp = head;

        System.out.println("\nMovies in Forward Order:");

        while (temp != null) {

            System.out.println("\nTitle: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);

            temp = temp.next;
        }
    }

    // Display movies in reverse order
    static void displayReverse() {

        if (tail == null) {
            System.out.println("Movie list is empty!");
            return;
        }

        Movie temp = tail;

        System.out.println("\nMovies in Reverse Order:");

        while (temp != null) {

            System.out.println("\nTitle: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);

            temp = temp.prev;
        }
    }

    // Update movie rating
    static void updateRating() {

        System.out.print("Enter Movie Title: ");
        String title = sc.nextLine();

        Movie temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                System.out.print("Enter New Rating: ");
                temp.rating = sc.nextDouble();
                sc.nextLine();

                System.out.println("Rating updated successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found!");
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MOVIE MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display Movies Forward");
            System.out.println("8. Display Movies Reverse");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    insertBeginning();
                    break;

                case 2:
                    insertEnd();
                    break;

                case 3:
                    insertPosition();
                    break;

                case 4:
                    removeMovie();
                    break;

                case 5:
                    searchDirector();
                    break;

                case 6:
                    searchRating();
                    break;

                case 7:
                    displayForward();
                    break;

                case 8:
                    displayReverse();
                    break;

                case 9:
                    updateRating();
                    break;

                case 10:
                    System.out.println("Program Exited!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}


