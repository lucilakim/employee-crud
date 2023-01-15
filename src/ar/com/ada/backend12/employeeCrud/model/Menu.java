package ar.com.ada.backend12.employeeCrud.model;

public class Menu {

    public Menu(){
    }

    /**
     * Prints the menu options for the user
     */
    public void printMenu() {
        String menu = "    ----------------- MENU ------------------ \n" +
                "    1. Add employees to the company.\n" +
                "    2. Consult data of one, or all employees.\n" +
                "    3. Update the information of an employee.\n" +
                "    4. Delete an employee.\n" +
                "    5. Exit.\n" +
                "    ----------------------------------------- \n";
        System.out.println(menu);
        System.out.print("Select a menu option: ");
    }
}
