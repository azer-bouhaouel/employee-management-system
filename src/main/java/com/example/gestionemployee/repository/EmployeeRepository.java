package com.example.gestionemployee.repository;
import com.example.gestionemployee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
    @Query("{'email':?0}")
    public Employee findByEmail(String email);

    @Query("{'salary':{'$gte':?0 , '$lte':?1}}")
    public List<Employee> findSalaryBetween(double minSalary , double maxSalary);
}


