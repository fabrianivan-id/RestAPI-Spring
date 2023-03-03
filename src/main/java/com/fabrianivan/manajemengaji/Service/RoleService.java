package com.fabrianivan.manajemengaji.Service;

import com.fabrianivan.manajemengaji.Entity.Role;

import com.fabrianivan.manajemengaji.Repository.PermissionRepository;
import com.fabrianivan.manajemengaji.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Permission;
import java.util.*;
@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    public Role CreateRoles(Role role){
        return roleRepository.save(role);
    }


    public void assignPermission(Map<String,Object> body) {
        Long convertedLong = Long.parseLong(body.get("id_role").toString());
        Role role = roleRepository.findOneId(convertedLong);
        List<Object> list = new ArrayList<>();
        if (body.get("permission").getClass().isArray()){
            list = Arrays.asList((Object[])body.get("permission"));
        }else if (body.get("permission") instanceof Collection) {
            list = new ArrayList<>((Collection<?>)body.get("permission"));
        }
        Set<Permission> permissions = new HashSet<>();
        list.stream().forEach(value -> {
            Permission permission = permissionRepository.findOneName(value.toString());
            if (permission != null){
                permissions.add(permission);
                System.out.println(permission);
                //role.setPermission(permissions);
            }
        });
        roleRepository.save(role);



    }

    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }
}