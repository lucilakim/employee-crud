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
    }

    public void printDepartmentMenu() {
        String departmentMenu = " >>> SELECT EMPLOYEE DEPARTMENTS \n" +
                "    1 - SYSTEMS,\n" +
                "    2 - HUMAN_RESOURCES,\n" +
                "    3 - ACCOUNTING,\n" +
                "    4 - CUSTOMER_SERVICE,\n" +
                "    5 - PROJECT_MANAGER,\n" +
                "    6 - UX_DESIGNER,\n" +
                "    7 - UI_DESIGNER,\n" +
                "    8 - BUSINESS_ANALYST,\n" +
                "    9 - BACKEND_DEVELOPER,\n" +
                "    10 - FRONTED_DEVELOPER,\n" +
                "    11 - TESTER_QA,\n" +
                "    12 - DATA_ANALYST,\n" +
                "    13 - TEAM_LEAD,\n" +
                "    14 - TEACH_LEAD,\n" +
                "    15 - SCRUM_MASTER.\n" +
                "    <<<";
        System.out.println(departmentMenu);

    }
}