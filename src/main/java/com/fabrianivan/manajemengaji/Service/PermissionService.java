package com.fabrianivan.manajemengaji.Service;

import com.fabrianivan.manajemengaji.Entity.Permission;
import com.fabrianivan.manajemengaji.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionService {

    private static PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        PermissionService.permissionRepository = permissionRepository;
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }
    public static class PermissionNotFoundException extends RuntimeException {

        public PermissionNotFoundException(Long id) {
            super("Could not find permission " + id);
        }
    }

    public static Permission getPermissionById(Long id) {
        return permissionRepository.findById(id).orElseThrow(() -> new PermissionNotFoundException(id));
    }

    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void deletePermissionById(Long id) {
        permissionRepository.deleteById(id);
    }

}