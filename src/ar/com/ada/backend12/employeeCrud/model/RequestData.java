package ar.com.ada.backend12.employeeCrud.model;

import ar.com.ada.backend12.employeeCrud.Utils.Util;

import java.util.Date;
import java.util.Scanner;

public class RequestData {
    Scanner sc = new Scanner(System.in);
    Util util = new Util();

    public RequestData() {
    }

    public int requestId(String action) {
        System.out.print("Enter the ID of the user to " + action + " [ex. 10]: ");
        return sc.nextInt();
    }
    public String requestName(String action) {
        System.out.print("Enter employee Name to " + action + ": ");
        return sc.nextLine();
    }
    public String requestNameOneWorld(String action) {
        System.out.print("Enter employee Name to " + action + ": ");
        return sc.next();
    }

    public String requestLastName(String action) {
        System.out.print("Enter employee Last Name to " + action + ": ");
        return sc.nextLine();
    }

    public String requestLastNameOneWorld(String action) {
        System.out.print("Enter employee Last Name to " + action + ": ");
        return sc.next();
    }

    public String requestDi(String action) {
        System.out.print("Enter employee DI to " + action + " [00.000.000]: ");
        return sc.nextLine();
    }

    public String requestDiOneWorld(String action) {
        System.out.print("Enter employee DI to " + action + " [00.000.000]: ");
        return sc.next();
    }

    public Date requestBirthDate(String action) {
        System.out.print("Enter employee Date of Birth to " + action + " [yyyy-mm-dd]: ");
        String birthString = sc.nextLine();
        return util.parseDate(birthString);
    }

    public Date requestBirthDateOneWorld(String action) {
        System.out.print("Enter employee Date of Birth to " + action + " [yyyy-mm-dd]: ");
        String birthString = sc.next();
        return util.parseDate(birthString);
    }

    public int requestDepartment(String action) {
        System.out.print("Enter a employee Department to " + action + " [ex. 12]: ");
        return sc.nextInt();
    }
    public int requestSalary(String action) {
        System.out.print("Enter employee Salary to " + action + " [ex. 5000]: ");
        return sc.nextInt();
    }
}
