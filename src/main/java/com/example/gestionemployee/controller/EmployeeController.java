package com.example.gestionemployee.controller;

import com.example.gestionemployee.model.Employee;
import com.example.gestionemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/byid/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }


    @GetMapping("/byemail")
    Employee getEmployeeByEmail(@RequestParam String email){
        return employeeService.getEmployeeByEmail(email);
    }

    @GetMapping("/getsalaries")
    List<Employee> getEmployeeByEmail(@RequestParam double minSalary, @RequestParam double maxSalary){
        return employeeService.getSalaryBetween(minSalary,maxSalary );
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping
    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete")
    public String deleteEmployeeById(@RequestParam String id) {
        return employeeService.deleteEmployeeById(id);
    }
}
