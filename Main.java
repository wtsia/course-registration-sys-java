import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Course course = new Course("CIS 255", 10, 10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: \n1) Add student \n2) Drop student \n3) View course \n4) Exit\n");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            if (choice == 1) {
                System.out.println("Enter the first name:");
                String firstName = scanner.nextLine();
                
                System.out.println("Enter the last name:");
                String lastName = scanner.nextLine();

                String id;
                while (true) {
                    System.out.println("Enter the ID:");
                    id = scanner.nextLine();
                    if (id.matches("\\w+") && !id.isEmpty()) {  
                        break;
                    } else {
                        System.out.println("Invalid input. ID needs to be inputted (0-9, a-Z).");
                    }
                }

                System.out.println("Has the student paid tuition? Enter Y or N");
                boolean tuitionPaid = scanner.nextLine().equalsIgnoreCase("Y") ? true : false;
                
                Student newStudent = new Student(firstName, lastName, id, tuitionPaid);

                if (course.addStudent(newStudent)) {
                    System.out.println(newStudent + " added successfully\n");
                } else {
                    System.out.println("Failed to add " + newStudent + "\n");
                }

            } else if (choice == 2) {
                System.out.println("Enter the first name");
                String firstName = scanner.nextLine();
                
                System.out.println("Enter the last name");
                String lastName = scanner.nextLine();
                
                System.out.println("Enter student id");
                String id = scanner.nextLine();
                
                System.out.println("Has the student paid tuition? Enter Y or N");
                boolean tuitionPaid = scanner.nextBoolean();
                scanner.nextLine();
                Student student = new Student(firstName, lastName, id, tuitionPaid);

                if (course.dropStudent(student)) {
                    System.out.println(student + " dropped successfully.\n");
                } else {
                    System.out.println("Failed to drop " + student + "\n");
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
