package ar.com.ada.backend12.employeeCrud.model;

import java.util.*;

public class CompanyEmployees {
    private Map<Integer, Employee> employees;

    public CompanyEmployees() {
        super();
        this.employees = new TreeMap<Integer, Employee>();
    }

    public void insert(Employee e) {
        employees.put(e.getId(), e);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void delete(int id) {
        employees.remove(id);
    }

    public boolean contains(int id) {
        return employees.containsKey(id);
    }

    public List<Employee> getEmployees(){
        List<Employee> out = new ArrayList<>();

        if (employees.isEmpty()) {
            return out;
        }

        Iterator<Integer> i = employees.keySet().iterator();

        while(i.hasNext()) {
            out.add(employees.get(i.next()));
        }

        return out;
    }
}
