
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecord {

    static Student head = null;
    static Scanner sc = new Scanner(System.in);

    // Insert at beginning
    static void insertBeginning() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newNode = new Student(roll, name, age, grade);

        newNode.next = head;
        head = newNode;

        System.out.println("Student added successfully");
    }

    // Insert at end
    static void insertEnd() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        System.out.println("Student added successfully");
    }

    // Insert at specific position
    static void insertPosition() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertBeginning();
            return;
        }

        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Grade: ");
        char grade = sc.next().charAt(0);

        Student newNode = new Student(roll, name, age, grade);

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Student added successfully");
    }

    // Delete by Roll Number
    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNo == roll) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.rollNo != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted");
        }
    }

    // Search by Roll Number
    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == roll) {
                System.out.println("Student Found!");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // Display all students
    static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Student temp = head;

        while (temp != null) {
            System.out.println("\nRoll No: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);

            temp = temp.next;
        }
    }

    // Update grade
    static void updateGrade() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == roll) {
                System.out.print("Enter new Grade: ");
                temp.grade = sc.next().charAt(0);

                System.out.println("Grade updated successfully");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT RECORD MANAGEMENT =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Display Students");
            System.out.println("7. Update Grade");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

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
                    deleteStudent();
                    break;

                case 5:
                    searchStudent();
                    break;

                case 6:
                    display();
                    break;

                case 7:
                    updateGrade();
                    break;

                case 8:
                    System.out.println("Program Exited");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
