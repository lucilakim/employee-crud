package ar.com.ada.backend12.employeeCrud.executable;

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
            System.out.println("\n===================== EMPLOYEE MANAGEMENT SYSTEM ======================\n");
            //1 - Connect to the database.
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Program
            final int EXIT_OPTION = 5;
            final int LOWER_OPTION = 1;
            final int UPPER_OPTION = 4;

            while (true) {
                printMenu();
                int inputMenuOption = validateInt(sc);

                if (inputMenuOption == EXIT_OPTION) {
                    break;
                } else if (inputMenuOption < LOWER_OPTION || inputMenuOption > UPPER_OPTION) {
                    System.out.println("ERROR! Enter a valid option from the menu.");
                    continue;
                }

                switch (inputMenuOption) {
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
            //5 - Close the connection to the database
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

    // --------------------------------------- STATIC FUNCTIONS ---------------------------------------

    /**
     * Prints the menu options for the user
     */
    private static void printMenu() {
        String menu = "    --------------->> MENU <<---------------- \n" +
                "    1. Add employees to the company.\n" +
                "    2. Consult data of one, or all employees.\n" +
                "    3. Update the information of an employee.\n" +
                "    4. Delete an employee.\n" +
                "    5. Exit.\n" +
                "    ----------------------------------------- \n";
        System.out.println(menu);
        System.out.print("Select a menu option: ");
    }

    /**
     * Validates if the value entered by the user is a number.
     *
     * @param sc - An object of type Scanner, to read the user's data.
     * @return value - If the value entered is a number, It RETURNS this NUMBER.
     * Else, RETURN an error message.
     */
    static int validateInt(Scanner sc) {
        Integer value = null;

        while (value == null) {
            try {
                value = Integer.parseInt(sc.nextLine());
            } catch (Exception ex) {
                System.out.println("ERROR! Enter a numerical value from the menu.");
                printMenu();
            }
        }
        return value;
    }

}