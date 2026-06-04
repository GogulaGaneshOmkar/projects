import java.util.ArrayList;
import java.util.Scanner;

// Employee Class
class Employee {

    int id;
    String name;
    double salary;

    // Constructor
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Display employee details
    void display() {
        System.out.println("----------------------------");
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : " + salary);
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList to store employees
        ArrayList<Employee> employees = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Add Employee
                case 1:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();

                    employees.add(new Employee(id, name, salary));

                    System.out.println("Employee Added Successfully!");
                    break;

                // View Employees
                case 2:

                    if (employees.isEmpty()) {
                        System.out.println("No employee records found.");
                    }
                    else {
                        System.out.println("\nEmployee Records:");

                        for (Employee emp : employees) {
                            emp.display();
                        }
                    }
                    break;

                // Update Employee
                case 3:

                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Employee emp : employees) {

                        if (emp.id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            emp.name = sc.nextLine();

                            System.out.print("Enter New Salary: ");
                            emp.salary = sc.nextDouble();

                            System.out.println("Employee Updated Successfully!");

                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee ID not found.");
                    }

                    break;

                // Delete Employee
                case 4:

                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (Employee emp : employees) {

                        if (emp.id == deleteId) {

                            employees.remove(emp);

                            System.out.println("Employee Deleted Successfully!");

                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Employee ID not found.");
                    }

                    break;

                // Exit
                case 5:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}