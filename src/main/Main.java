package main;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<String> students = new ArrayList<>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add student");
            System.out.println("2. View students");
            System.out.println("3. Remove student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            while (!input.hasNextInt()) {
                System.out.print("Please enter a number (1-4): ");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = input.nextLine().trim();
                    if (!name.isEmpty()) {
                        students.add(name);
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Name cannot be empty.");
                    }
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students have been added yet.");
                    } else {
                        System.out.println("\nStudent List:");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println((i + 1) + ". " + students.get(i));
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("There are no students to remove.");
                    } else {
                        System.out.print("Enter student number to remove: ");
                        if (input.hasNextInt()) {
                            int number = input.nextInt();
                            input.nextLine();
                            if (number >= 1 && number <= students.size()) {
                                String removed = students.remove(number - 1);
                                System.out.println(removed + " removed successfully.");
                            } else {
                                System.out.println("Invalid student number.");
                            }
                        } else {
                            System.out.println("Please enter a valid number.");
                            input.nextLine();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Choose between 1 and 4.");
            }
        } while (choice != 4);

        input.close();
    }
}
