package be.intecbrussel.springboot.service;

import be.intecbrussel.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
}
