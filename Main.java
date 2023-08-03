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
                System.out.println("Enter the first name:");
                String firstName = scanner.nextLine();
                
                System.out.println("Enter the last name:");
                String lastName = scanner.nextLine();

                String id;
                while (true) {
                    System.out.println("Enter the ID number:");
                    id = scanner.nextLine();
                    if (id.matches("\\w+") && !id.isEmpty()) {  
                        break;
                    } else {
                        System.out.println("Invalid input. ID number needs to be inputted.");
                    }
                }

                System.out.println("Has the student paid tuition? Enter Y or N");
                boolean tuitionPaid = scanner.nextLine().equalsIgnoreCase("Y") ? true : false;
                
                Student newStudent = new Student(firstName, lastName, id, tuitionPaid);

                if (course.addStudent(newStudent)) {
                    System.out.println("Student added successfully.");
                } else {
                    System.out.println("Failed to add student.");
                }

            } else if (choice == 2) {
                System.out.println("Enter the ID of student to drop");
                String id = scanner.nextLine();

                if (course.dropStudent(id)) {
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
