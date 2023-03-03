package com.fabrianivan.manajemengaji.Repository;

import com.fabrianivan.manajemengaji.Entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    @Query("SELECT u FROM Role u WHERE u.id_roles = ?1")
    Role findOneId(Long id);
}