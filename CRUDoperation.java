import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a person with name and age
class Person {
    String name;
    int age;

    // Constructor to initialize name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding toString() method for better display
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class CRUDoperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Create
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    people.add(new Person(name, age));
                    System.out.println("Person added successfully!");
                    break;

                case 2: // Read
                    System.out.println("Current Records:");
                    if (people.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (int i = 0; i < people.size(); i++) {
                            System.out.println((i + 1) + ". " + people.get(i));
                        }
                    }
                    break;

                case 3: // Update
                    System.out.println("Current Records:");
                    if (people.isEmpty()) {
                        System.out.println("No records to update.");
                    } else {
                        for (int i = 0; i < people.size(); i++) {
                            System.out.println((i + 1) + ". " + people.get(i));
                        }
                        System.out.print("Enter record number to update: ");
                        int updateIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consume newline
                        if (updateIndex >= 0 && updateIndex < people.size()) {
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new age: ");
                            int newAge = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            people.set(updateIndex, new Person(newName, newAge));
                            System.out.println("Record updated successfully!");
                        } else {
                            System.out.println("Invalid record number.");
                        }
                    }
                    break;

                case 4: // Delete
                    System.out.println("Current Records:");
                    if (people.isEmpty()) {
                        System.out.println("No records to delete.");
                    } else {
                        for (int i = 0; i < people.size(); i++) {
                            System.out.println((i + 1) + ". " + people.get(i));
                        }
                        System.out.print("Enter record number to delete: ");
                        int deleteIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consume newline
                        if (deleteIndex >= 0 && deleteIndex < people.size()) {
                            people.remove(deleteIndex);
                            System.out.println("Record deleted successfully!");
                        } else {
                            System.out.println("Invalid record number.");
                        }
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
