package com.fabrianivan.manajemengaji.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    /*
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Long id) {
        Role role = roleService.findById(id);
        return ResponseEntity.ok().body(role);
    }

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@Valid @RequestBody Role role) {
        Role newRole = roleService.addRole(role);
        return ResponseEntity.ok().body(newRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Role role) {
        Role updatedRole = roleService.updateRole(id, role);
        return ResponseEntity.ok().body(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable(value = "id") Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/assign")
    private ResponseEntity<?> AssignPermission(@RequestBody  Map<String,Object> roles){
        roleService.assignPermission(roles);
        return ResponseEntity.ok().build();

     */
}