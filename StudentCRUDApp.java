import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

public class StudentCRUDApp {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    studentList.add(new Student(id, name, marks));
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    // View Students
                    if (studentList.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n-- Student Records --");
                        for (Student s : studentList) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    // Update Student
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    boolean found = false;
                    for (Student s : studentList) {
                        if (s.getId() == updateId) {
                            scanner.nextLine(); // clear buffer
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new marks: ");
                            double newMarks = scanner.nextDouble();
                            s.setName(newName);
                            s.setMarks(newMarks);
                            System.out.println("✅ Student updated successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Student with ID " + updateId + " not found.");
                    }
                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    found = false;
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getId() == deleteId) {
                            studentList.remove(i);
                            System.out.println("✅ Student deleted successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
