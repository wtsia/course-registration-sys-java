import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("CIS 255", 10, 10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: 1) Add student 2) Drop student 3) View course 4) Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter student ID, first name, last name, and tuition paid status (true or false)");
                int id;
                while (true) {
                    try {
                        id = scanner.nextInt();
                        break; 
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Student ID should be a number.");
                        scanner.nextLine(); 
                    }
                }
                String firstName = scanner.next();
                String lastName = scanner.next();
                boolean tuitionPaid = scanner.nextBoolean();
                Student newStudent = new Student(id, firstName, lastName, tuitionPaid);

                if (course.addStudent(newStudent)) {
                    System.out.println("Student added successfully.");
                } else {
                    System.out.println("Failed to add student.");
                }

            } else if (choice == 2) {
                System.out.println("Enter student information to drop");
                int id = scanner.nextInt();
                String firstName = scanner.next();
                String lastName = scanner.next();
                boolean tuitionPaid = scanner.nextBoolean();
                Student student = new Student(id, firstName, lastName, tuitionPaid);

                if (course.dropStudent(student)) {
                    System.out.println("Student dropped successfully.");
                } else {
                    System.out.println("Failed to drop student.");
                }

            } else if (choice == 3) {
                System.out.println(course);

            } else if (choice == 4) {
                scanner.close();
                break;
            }
        }
    }
}
