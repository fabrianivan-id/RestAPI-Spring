package com.fabrianivan.manajemengaji.Repository;

import com.fabrianivan.manajemengaji.Entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee WHERE department = :department", nativeQuery = true)
    List<Employee> findByDepartment(@Param("department") String department);

    @Query(value = "SELECT * FROM employee WHERE month(pay_date) = :month AND year(pay_date) = :year", nativeQuery = true)
    List<Employee> findByPayDate(@Param("month") int month, @Param("year") int year);
}

