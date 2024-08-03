import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }
                    System.out.print("Enter roll number: ");
                    int rollNumber;
                    try {
                        rollNumber = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number!");
                        break;
                    }
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    if (grade.isEmpty()) {
                        System.out.println("Grade cannot be empty!");
                        break;
                    }
                    System.out.print("Enter age: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age!");
                        break;
                    }
                    sms.addStudent(new Student(name, rollNumber, grade, age));
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    sms.removeStudent(removeRollNumber);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Optional<Student> student = sms.searchStudent(searchRollNumber);
                    student.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Student not found!")
                    );
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

