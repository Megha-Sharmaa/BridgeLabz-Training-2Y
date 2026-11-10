
import java.util.Scanner;
import java.util.ArrayList;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {

    static User head = null;
    static Scanner sc = new Scanner(System.in);

    // Add a new user
    static void addUser() {

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findUser(id) != null) {
            System.out.println("User ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        User newNode = new User(id, name, age);

        if (head == null) {
            head = newNode;
        } else {
            User temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("User added successfully!");
    }

    // Find user by ID
    static User findUser(int id) {

        User temp = head;

        while (temp != null) {
            if (temp.userId == id) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    // Add friend connection
    static void addFriend() {

        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        if (id1 == id2) {
            System.out.println("A user cannot be their own friend!");
            return;
        }

        User user1 = findUser(id1);
        User user2 = findUser(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        if (user1.friends.contains(id2)) {
            System.out.println("Friend connection already exists!");
            return;
        }

        user1.friends.add(id2);
        user2.friends.add(id1);

        System.out.println("Friend connection added successfully!");
    }

    // Remove friend connection
    static void removeFriend() {

        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User user1 = findUser(id1);
        User user2 = findUser(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        if (user1.friends.contains(id2)) {
            user1.friends.remove(Integer.valueOf(id2));
            user2.friends.remove(Integer.valueOf(id1));

            System.out.println("Friend connection removed!");
        } else {
            System.out.println("Friend connection does not exist!");
        }
    }

    // Find mutual friends
    static void mutualFriends() {

        System.out.print("Enter First User ID: ");
        int id1 = sc.nextInt();

        System.out.print("Enter Second User ID: ");
        int id2 = sc.nextInt();

        User user1 = findUser(id1);
        User user2 = findUser(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        boolean found = false;

        System.out.println("\nMutual Friends:");

        for (int friendId : user1.friends) {

            if (user2.friends.contains(friendId)) {

                User friend = findUser(friendId);

                if (friend != null) {
                    System.out.println("User ID: " + friend.userId);
                    System.out.println("Name: " + friend.name);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No mutual friends found!");
        }
    }

    // Display all friends of a user
    static void displayFriends() {

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        User user = findUser(id);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        if (user.friends.isEmpty()) {
            System.out.println("No friends found!");
            return;
        }

        System.out.println("\nFriends of " + user.name + ":");

        for (int friendId : user.friends) {

            User friend = findUser(friendId);

            if (friend != null) {
                System.out.println("User ID: " + friend.userId);
                System.out.println("Name: " + friend.name);
                System.out.println("Age: " + friend.age);
                System.out.println("-------------------");
            }
        }
    }

    // Search user by ID
    static void searchById() {

        System.out.print("Enter User ID: ");
        int id = sc.nextInt();

        User user = findUser(id);

        if (user != null) {
            System.out.println("\nUser Found!");
            System.out.println("User ID: " + user.userId);
            System.out.println("Name: " + user.name);
            System.out.println("Age: " + user.age);
        } else {
            System.out.println("User not found!");
        }
    }

    // Search user by Name
    static void searchByName() {

        System.out.print("Enter User Name: ");
        String name = sc.nextLine();

        User temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.name.equalsIgnoreCase(name)) {

                System.out.println("\nUser Found!");
                System.out.println("User ID: " + temp.userId);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);

                found = true;
            }

            temp = temp.next;
        }

        if (!found) {
            System.out.println("User not found!");
        }
    }

    // Count friends of each user
    static void countFriends() {

        if (head == null) {
            System.out.println("No users available!");
            return;
        }

        User temp = head;

        System.out.println("\n===== FRIEND COUNT =====");

        while (temp != null) {

            System.out.println("User ID: " + temp.userId);
            System.out.println("Name: " + temp.name);
            System.out.println("Total Friends: " + temp.friends.size());

            System.out.println("-------------------");

            temp = temp.next;
        }
    }

    // Display all users
    static void displayUsers() {

        if (head == null) {
            System.out.println("No users available!");
            return;
        }

        User temp = head;

        while (temp != null) {

            System.out.println("\nUser ID: " + temp.userId);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Total Friends: " + temp.friends.size());

            temp = temp.next;
        }
    }

    // Main method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== SOCIAL MEDIA FRIEND SYSTEM =====");

            System.out.println("1. Add New User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends");
            System.out.println("6. Search User by ID");
            System.out.println("7. Search User by Name");
            System.out.println("8. Count Friends of Each User");
            System.out.println("9. Display All Users");
            System.out.println("10. Exit");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addUser();
                    break;

                case 2:
                    addFriend();
                    break;

                case 3:
                    removeFriend();
                    break;

                case 4:
                    mutualFriends();
                    break;

                case 5:
                    displayFriends();
                    break;

                case 6:
                    searchById();
                    break;

                case 7:
                    searchByName();
                    break;

                case 8:
                    countFriends();
                    break;

                case 9:
                    displayUsers();
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
