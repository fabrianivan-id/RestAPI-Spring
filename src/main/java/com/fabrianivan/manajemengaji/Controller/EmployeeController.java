package com.fabrianivan.manajemengaji.Controller;

import com.fabrianivan.manajemengaji.Entity.Employee;
import com.fabrianivan.manajemengaji.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(params = {"department"})
    public List<Employee> getEmployeesByDepartment(@RequestParam("department") String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(params = {"month", "year"})
    public List<Employee> getEmployeesByPayDate(@RequestParam("month") int month, @RequestParam("year") int year) {
        return employeeService.getEmployeesByPayDate(month, year);
    }
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(params = {"ids"})
    public List<Employee> getEmployeesByIds(@RequestParam("ids") List<Long> ids) {
        return employeeService.getEmployeesByIds(ids);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(null);
        employeeService.addEmployee(employee);
        return employee;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return employee;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " has been deleted";
    }
}