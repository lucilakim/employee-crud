package ar.com.ada.backend12.employeeCrud.executable;

import ar.com.ada.backend12.employeeCrud.Utils.Util;
import ar.com.ada.backend12.employeeCrud.Utils.Validations;
import ar.com.ada.backend12.employeeCrud.model.CompanyEmployees;
import ar.com.ada.backend12.employeeCrud.model.Employee;
import ar.com.ada.backend12.employeeCrud.model.HandlerOptions;
import ar.com.ada.backend12.employeeCrud.model.Menu;

import java.sql.*;
import java.util.Scanner;

public class EmployeeCrud {
    private static final String URL = "jdbc:mysql://localhost:3306/RRHH";
    private static final String USER = "root";
    private static final String PASS = "r1qw259-";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //1 - Connect to the database.
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Program
            System.out.println("\n===================== EMPLOYEE MANAGEMENT SYSTEM ======================\n");
            Menu menu = new Menu();
            Util util = new Util();
            Validations validation = new Validations();
            CompanyEmployees companyEmployees = new CompanyEmployees();
            HandlerOptions handlerOptions = new HandlerOptions();

            final int EXIT_OPTION = 5;
            final int LOWER_OPTION = 1;
            final int UPPER_OPTION = 4;

            while (true) {
                menu.printMenu();
                System.out.print("Select a menu option: ");
                int menuOption = validation.validateInt(sc);

                if (menuOption == EXIT_OPTION) {
                    break;
                } else if (menuOption < LOWER_OPTION || menuOption > UPPER_OPTION) {
                    System.out.println("ERROR! Enter a valid option from the menu.");
                    continue;
                }

                String firstName;
                String lastName;
                String di;
                String birthString;
                java.util.Date birthDate;
                int department;
                int salary;

                switch (menuOption) {
                    case 1:
                        System.out.println("\n ------> Option 1 - Add employees");

                        // Request for necessary data for the query
                        System.out.print("Enter employee Name: ");
                        firstName = sc.nextLine();
                        System.out.print("Enter employee Last Name: ");
                        lastName = sc.nextLine();
                        System.out.print("Enter employee DI [00.000.000]: ");
                        di = sc.nextLine();
                        System.out.print("Enter employee Date of Birth [yyyy-mm-dd]: ");
                        birthString = sc.nextLine();
                        birthDate = util.parseDate(birthString);
                        menu.printDepartmentMenu();
                        System.out.print("Enter a employee Department: ");
                        department = sc.nextInt();
                        System.out.print("Enter employee Salary [ex. 5000]: ");
                        salary = sc.nextInt();

                        // Add employee in database and get employeeId
                        Integer newEmployeeId = handlerOptions.insertEmployee(conn, firstName, lastName, di, birthDate, department, salary);

                        // If the employee is added to the database,
                        // - Create the person instance.
                        // - And add it to the company TreeMap
                        if (newEmployeeId > 0) {
                            Employee newEmployee = new Employee(newEmployeeId, firstName, lastName, di, birthDate, department, salary);
                            companyEmployees.insert(newEmployee);
                            System.out.println("\nAdding employee...");
                            System.out.println("Employee successfully entered into the system.");
                        }
                        break;

                    case 2:
                        System.out.println("Consult");
                        break;
                    case 3:
                        System.out.println("Update");
                        break;
                    case 4:
                        System.out.println("Delete");
                        break;
                }
            }
            System.out.println("------> End of Program");

        } catch (SQLException e) {
            System.out.println("EXCEPTION! An error has occurred in the program. Execution is aborted");
            e.printStackTrace();
        } finally {
            //5 - Close database connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException f) {
                    f.printStackTrace();
                }
            }
        }
        // Close Scanner
        sc.close();
        System.out.println("======================================================================= \n");
    }
}
