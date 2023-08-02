import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("CIS 255", 10, 10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: 1) Add student 2) Drop student 3) View course 4) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            if (choice == 1) {
                System.out.println("Enter student ID, first name, last name, and tuition paid status (true or false)");
                String id;
                while (true) {
                    id = scanner.nextLine();
                    if (id.matches("\\d+")) {  
                        break;
                    } else {
                        System.out.println("Invalid input. Student ID should be a number.");
                    }
                }
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                boolean tuitionPaid = scanner.nextBoolean();
                scanner.nextLine();  
                Student newStudent = new Student(firstName, lastName, id, tuitionPaid);

                if (course.addStudent(newStudent)) {
                    System.out.println("Student added successfully.");
                } else {
                    System.out.println("Failed to add student.");
                }

            } else if (choice == 2) {
                System.out.println("Enter student information to drop");
                String id = scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                boolean tuitionPaid = scanner.nextBoolean();
                scanner.nextLine();  // Consume newline left-over
                Student student = new Student(firstName, lastName, id, tuitionPaid);

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
