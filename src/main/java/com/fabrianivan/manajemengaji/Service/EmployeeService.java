package com.fabrianivan.manajemengaji.Service;

import com.fabrianivan.manajemengaji.Entity.Employee;
import com.fabrianivan.manajemengaji.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public static class EmployeeNotFoundException extends RuntimeException {

        public EmployeeNotFoundException(Long id) {
            super("Could not find employee " + id);
        }
    }


    public abstract List<Employee> getEmployeesByDepartment(String department);

    public abstract List<Employee> getEmployeesByPayDate(int month, int year);

    public abstract List<Employee> getEmployeesByIds(List<Long> ids);

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        employee.setPayDate(employeeDetails.getPayDate());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

