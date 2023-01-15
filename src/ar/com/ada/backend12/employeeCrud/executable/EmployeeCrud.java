package ar.com.ada.backend12.employeeCrud.executable;

import ar.com.ada.backend12.employeeCrud.Util.Validations;
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
            Validations validation = new Validations();

            final int EXIT_OPTION = 5;
            final int LOWER_OPTION = 1;
            final int UPPER_OPTION = 4;

            while (true) {
                menu.printMenu();
                int menuOption = validation.validateInt(sc);

                if (menuOption == EXIT_OPTION) {
                    break;
                } else if (menuOption < LOWER_OPTION || menuOption > UPPER_OPTION) {
                    System.out.println("ERROR! Enter a valid option from the menu.");
                    continue;
                }

                switch (menuOption) {
                    case 1:
                        System.out.println("Add");
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
