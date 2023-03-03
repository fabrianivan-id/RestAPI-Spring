package com.fabrianivan.manajemengaji.Service;

import com.fabrianivan.manajemengaji.Entity.Employee;
import com.fabrianivan.manajemengaji.Entity.Permission;
import com.fabrianivan.manajemengaji.Entity.Role;
import com.fabrianivan.manajemengaji.Repository.EmployeeRepository;
import com.fabrianivan.manajemengaji.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class PermissionService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public PermissionService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    /*
    @Override
    public boolean hasPermission(Long id, String permission) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Set<Role> roles = employee.get().getRoles();
            for (Role role : roles) {
                Set<Permission> permissions = role.getPermissions();
                for (Permission p : permissions) {
                    if (p.getName().equals(permission)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public Permission createPermission(Permission permission){
        return  permissionRepository.save(permission);
    }

     */
}
