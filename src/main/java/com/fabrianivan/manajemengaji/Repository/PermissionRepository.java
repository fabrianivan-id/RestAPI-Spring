package com.fabrianivan.manajemengaji.Repository;

import com.fabrianivan.manajemengaji.Entity.Employee;
import com.fabrianivan.manajemengaji.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Optional<Permission> findByRole(Role role);
    Optional<Permission> findByEmployee(Employee employee);

}

