package com.fabrianivan.manajemengaji.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.security.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission,Long> {
    @Query("SELECT u FROM Permission u WHERE u.name = ?1")
    Permission findOneName(String id);
}