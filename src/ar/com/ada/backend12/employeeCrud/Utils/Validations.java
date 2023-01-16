package ar.com.ada.backend12.employeeCrud.Util;

import ar.com.ada.backend12.employeeCrud.model.Menu;

import java.util.Scanner;

public class Validations {

    public Validations() {
    }

    Menu menu = new Menu();

    /**
     * Validates if the value entered by the user is a number.
     *
     * @param sc An object of type Scanner, to read the user's data.
     * @return value - If the value entered is a number, It RETURNS this NUMBER.
     * Else, catch an Exception and RETURN an error message.
     */
    public int validateInt(Scanner sc) {
        Integer value = null;

        while (value == null) {
            try {
                value = Integer.parseInt(sc.nextLine());
            } catch (Exception ex) {
                System.out.println(value);
                System.out.println("ERROR! Enter a numerical value from the menu.");
                menu.printMenu();
            }
        }

        return value;
    }
}
