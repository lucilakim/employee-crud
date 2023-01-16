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
    int department;
    Timestamp hiringDate;
    int salary;

    // Constructor
    public Employee(int id, String firstName, String lastName, String di, Date birthDate, int department, Timestamp hiringDate, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.di = di;
        this.birthDate = birthDate;
        this.department = department;
        this.hiringDate = hiringDate;
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

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Timestamp getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Timestamp hiringDate) {
        this.hiringDate = hiringDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Equals - HashCode - ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && di == employee.di && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(birthDate, employee.birthDate) && Objects.equals(department, employee.department) && Objects.equals(hiringDate, employee.hiringDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, di, birthDate, department, hiringDate, salary);
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
                ", hiringDate=" + hiringDate +
                ", salary=" + salary +
                '}';
    }
}

