
import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    String availability;

    Book next;
    Book prev;

    Book(String title, String author, String genre, int bookId, String availability) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availability = availability;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagement {

    static Book head = null;
    static Book tail = null;

    static Scanner sc = new Scanner(System.in);

    // Add book at beginning
    static void insertBeginning() {

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Availability (Available/Issued): ");
        String availability = sc.nextLine();

        Book newNode = new Book(title, author, genre, id, availability);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println("Book added successfully!");
    }

    // Add book at end
    static void insertEnd() {

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Availability (Available/Issued): ");
        String availability = sc.nextLine();

        Book newNode = new Book(title, author, genre, id, availability);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Book added successfully!");
    }

    // Add book at specific position
    static void insertPosition() {

        System.out.print("Enter Position: ");
        int pos = sc.nextInt();
        sc.nextLine();

        if (pos < 1) {
            System.out.println("Invalid Position!");
            return;
        }

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Book temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Availability (Available/Issued): ");
        String availability = sc.nextLine();

        Book newNode = new Book(title, author, genre, id, availability);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;

        System.out.println("Book added successfully!");
    }

    // Remove book by Book ID
    static void removeBook() {

        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();
        sc.nextLine();

        Book temp = head;

        while (temp != null) {

            if (temp.bookId == id) {

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

                System.out.println("Book removed successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found!");
    }

    // Search book by title
    static void searchByTitle() {

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        Book temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {

                System.out.println("\nBook Found!");
                System.out.println("Title: " + temp.title);
                System.out.println("Author: " + temp.author);
                System.out.println("Genre: " + temp.genre);
                System.out.println("Book ID: " + temp.bookId);
                System.out.println("Availability: " + temp.availability);

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Search book by author
    static void searchByAuthor() {

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.author.equalsIgnoreCase(author)) {

                System.out.println("\nBook Found!");
                System.out.println("Title: " + temp.title);
                System.out.println("Author: " + temp.author);
                System.out.println("Genre: " + temp.genre);
                System.out.println("Book ID: " + temp.bookId);
                System.out.println("Availability: " + temp.availability);

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Update availability status
    static void updateAvailability() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Book temp = head;

        while (temp != null) {

            if (temp.bookId == id) {

                System.out.print("Enter New Availability (Available/Issued): ");
                temp.availability = sc.nextLine();

                System.out.println("Availability updated successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Book not found!");
    }

    // Display books in forward order
    static void displayForward() {

        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }

        Book temp = head;

        System.out.println("\n===== BOOKS IN FORWARD ORDER =====");

        while (temp != null) {

            System.out.println("\nBook Title: " + temp.title);
            System.out.println("Author: " + temp.author);
            System.out.println("Genre: " + temp.genre);
            System.out.println("Book ID: " + temp.bookId);
            System.out.println("Availability: " + temp.availability);

            temp = temp.next;
        }
    }

    // Display books in reverse order
    static void displayReverse() {

        if (tail == null) {
            System.out.println("Library is empty!");
            return;
        }

        Book temp = tail;

        System.out.println("\n===== BOOKS IN REVERSE ORDER =====");

        while (temp != null) {

            System.out.println("\nBook Title: " + temp.title);
            System.out.println("Author: " + temp.author);
            System.out.println("Genre: " + temp.genre);
            System.out.println("Book ID: " + temp.bookId);
            System.out.println("Availability: " + temp.availability);

            temp = temp.prev;
        }
    }

    // Count total books
    static void countBooks() {

        int count = 0;

        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total Number of Books: " + count);
    }

    // Main method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books Forward");
            System.out.println("9. Display Books Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");

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
                    removeBook();
                    break;

                case 5:
                    searchByTitle();
                    break;

                case 6:
                    searchByAuthor();
                    break;

                case 7:
                    updateAvailability();
                    break;

                case 8:
                    displayForward();
                    break;

                case 9:
                    displayReverse();
                    break;

                case 10:
                    countBooks();
                    break;

                case 11:
                    System.out.println("Program Exited!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
