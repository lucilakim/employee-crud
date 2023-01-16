package ar.com.ada.backend12.employeeCrud.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Employee {
    // Attributes
    int id;
    String firstName;
    String lastName;
    String di;
    Date birthDate;
    Department department;
    int salary;

    // Constructor
    public Employee(int id, String firstName, String lastName, String di, Date birthDate, int departmentId, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.di = di;
        this.birthDate = birthDate;
        setDepartment(departmentId);
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(int departmentId) {
        switch (departmentId) {
            case 1:
                this.department = Department.SYSTEMS;
                break;
            case 2:
                this.department = Department.HUMAN_RESOURCES;
                break;
            case 3:
                this.department = Department.ACCOUNTING;
                break;
            case 4:
                this.department = Department.CUSTOMER_SERVICE;
                break;
            case 5:
                this.department = Department.PROJECT_MANAGER;
                break;
            case 6:
                this.department = Department.UX_DESIGNER;
                break;
            case 7:
                this.department = Department.UI_DESIGNER;
                break;
            case 8:
                this.department = Department.BUSINESS_ANALYST;
                break;
            case 9:
                this.department = Department.BACKEND_DEVELOPER;
                break;
            case 10:
                this.department = Department.FRONTED_DEVELOPER;
                break;
            case 11:
                this.department = Department.TESTER_QA;
                break;
            case 12:
                this.department = Department.DATA_ANALYST;
                break;
            case 13:
                this.department = Department.TEAM_LEAD;
                break;
            case 14:
                this.department = Department.TEACH_LEAD;
                break;
            case 15:
                this.department = Department.SCRUM_MASTER;
                break;
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int updateEmployee(int id, String firstName, String lastName, String di, Date birthDate, int departmentId, int salary){
        try {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.di = di;
            this.birthDate = birthDate;
            setDepartment(departmentId);
            this.salary = salary;
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    // Equals - HashCode - ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(di, employee.di) && Objects.equals(birthDate, employee.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, di, birthDate, department, salary);
    }

    @Override
    public String toString() {
        return "ar.com.ada.backend12.employeeCrud.model.Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", di=" + di +
                ", birthDate=" + birthDate +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

