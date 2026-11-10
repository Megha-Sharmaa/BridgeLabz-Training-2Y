
import java.util.Scanner;

public class TextEditor {

    static class Node {
        String text;
        Node prev;
        Node next;

        Node(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node current = null;

    int size = 0;
    final int MAX_HISTORY = 10;

    // Add new text
    void addText(String text) {

        Node newNode = new Node(text);

        // Delete redo history
        if (current != null) {

            Node temp = current.next;

            while (temp != null) {
                size--;
                temp = temp.next;
            }

            current.next = null;
        }

        // Add new node
        if (head == null) {
            head = newNode;
        } else {
            newNode.prev = current;
            current.next = newNode;
        }

        current = newNode;
        size++;

        // Maintain maximum 10 states
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text added successfully.");
    }

    // Undo
    void undo() {

        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo!");
            return;
        }

        current = current.prev;

        System.out.println("Undo successful.");
    }

    // Redo
    void redo() {

        if (current == null || current.next == null) {
            System.out.println("Nothing to redo!");
            return;
        }

        current = current.next;

        System.out.println("Redo successful.");
    }

    // Display current text
    void displayCurrentText() {

        if (current == null) {
            System.out.println("Text editor is empty.");
        } else {
            System.out.println("Current Text: " + current.text);
        }
    }

    // Display history
    void displayHistory() {

        if (head == null) {
            System.out.println("No history available.");
            return;
        }

        Node temp = head;

        System.out.println("\nText History:");

        while (temp != null) {

            if (temp == current) {
                System.out.println(temp.text + " <-- Current State");
            } else {
                System.out.println(temp.text);
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TextEditor editor = new TextEditor();

        int choice;

        do {

            System.out.println("\n===== TEXT EDITOR =====");
            System.out.println("1. Add New Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addText(text);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrentText();
                    break;

                case 5:
                    editor.displayHistory();
                    break;

                case 6:
                    System.out.println("Exiting Text Editor...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
