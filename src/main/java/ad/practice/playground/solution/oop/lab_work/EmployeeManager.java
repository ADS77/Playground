package ad.practice.playground.solution.oop.lab_work;

public class EmployeeManager {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===\n");

        // Create part-time and full-time employee with constructor
        FullTimeEmployee ftEmployee1 = new FullTimeEmployee("X1", 1001, 50000.00);
        FullTimeEmployee ftEmployee2 = new FullTimeEmployee("X2", 1002, 60000.00);
        PartTimeEmployee ptEmployee1 = new PartTimeEmployee("Y1", 80, 250.50, 1003);
        PartTimeEmployee ptEmployee2 = new PartTimeEmployee("Y2", 70, 300, 1004);

        // Display individual employee information
        System.out.println("Individual Employee Information:");
        ftEmployee1.displayInfo();
        ftEmployee2.displayInfo();
        ptEmployee1.displayInfo();
        ptEmployee2.displayInfo();

        //polymorphism using Employee array
        System.out.println("\n=== Polymorphism Demonstration ===");
        Employee[] employees = {ftEmployee1,ftEmployee2,ptEmployee1, ptEmployee2};

        // Process all employees using polymorphism
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Processing Employee " + (i + 1) + ":");
            employees[i].displayInfo();
        }

        // Alternative: Enhanced for loop
        System.out.println("\n=== Using Enhanced For Loop ===");
        for (Employee emp : employees) {
            System.out.println("Employee: " + emp.getName() + " | Salary:" + String.format("%.2f", emp.calculateSalary()));
        }

        // Demonstrate runtime polymorphism
        System.out.println("\n=== Runtime Polymorphism Demo ===");
        demonstratePolymorphism(ftEmployee1);
        demonstratePolymorphism(ptEmployee2);
    }

    // Method to demonstrate polymorphism - accepts any Employee type
    public static void demonstratePolymorphism(Employee employee) {
        System.out.println("Processing employee through polymorphic method:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Calculated Salary: $" + String.format("%.2f", employee.calculateSalary()));
        System.out.println("Actual Type: " + employee.getClass().getSimpleName());
        System.out.println();
    }
}
