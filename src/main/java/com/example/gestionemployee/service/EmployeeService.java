package com.example.gestionemployee.service;
import com.example.gestionemployee.model.Employee;
import com.example.gestionemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public String updateEmployee(Employee employee){
        Employee existed = employeeRepository.findByEmail(employee.getEmail());
        if(existed == null){
            return "employee doesn't exists !";
        }
        if(employee.getSalary() < 500.0){
            return "salary is invalid !";
        }
        existed.setSalary(employee.getSalary());
        existed.setRole(employee.getRole());
        existed.setName(employee.getName());
        employeeRepository.save(existed);
        return existed.toString();
    }
    public String addEmployee(Employee employee){
        Employee exists = employeeRepository.findByEmail(employee.getEmail());
        if(exists != null){
            return "employee exists !";
        }
        if(employee.getSalary() <500.0){
            return "salary is invalid !";
        }
        employeeRepository.insert(employee);
        return "employee added !";
    }

    public String deleteEmployeeById(String id){
        Employee exists = employeeRepository.findById(id).orElse(null);
        if(exists == null){
            return "employee doesn't exist !";
        }
        employeeRepository.deleteById(id);
        return "employee deleted !";
    }

    public List<Employee> getSalaryBetween(double minSalary, double maxSalary){
        return employeeRepository.findSalaryBetween(minSalary, maxSalary);
    }
}
