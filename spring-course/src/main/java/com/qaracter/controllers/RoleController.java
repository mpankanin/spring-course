package com.qaracter.controllers;

import com.qaracter.models.Grant;
import com.qaracter.models.Role;
import com.qaracter.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/roles")
class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<Set<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @GetMapping("/{roleId}/grants")
    public ResponseEntity<Set<Grant>> getGrantsByRoleId(@PathVariable Integer roleId) {
        return ResponseEntity.ok(roleService.getGrantsByRoleId(roleId));
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.createRole(role);
        return ResponseEntity.status(201).body(createdRole);
    }

    @PostMapping("/{roleId}/grants")
    public ResponseEntity<Grant> createGrant(@PathVariable Integer roleId, @RequestBody Grant grant) {
        Grant createdGrant = roleService.createGrant(grant);
        return ResponseEntity.status(201).body(createdGrant);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<Role> updateRole(@PathVariable Integer roleId, @RequestBody Role role) {
        Role roleTmp = roleService.updateRole(roleId, role);

        if (roleTmp != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{roleId}/grants")
    public ResponseEntity<Role> addGrantToRole(@PathVariable Integer roleId, @RequestBody Grant grant) {
        Role updatedRole = roleService.addGrantToRole(roleId, grant);
        return ResponseEntity.ok().body(updatedRole);
    }

    @PatchMapping("/{roleId}/grants/{grantId}")
    public ResponseEntity<Role> removeGrantFromRole(@PathVariable Integer roleId, @PathVariable Integer grantId) {
        Role updatedRole = roleService.removeGrantFromRole(roleId, grantId);
        return ResponseEntity.ok().body(updatedRole);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer roleId) {
        if (roleService.getRoleById(roleId) == null) {
            return ResponseEntity.notFound().build();
        }
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{roleId}/grants/{grantId}")
    public ResponseEntity<Void> deleteGrant(@PathVariable Integer roleId, @PathVariable Integer grantId) {
        if (!(roleService.getGrantById(grantId) == null)) {
            return ResponseEntity.notFound().build();
        }
        roleService.deleteGrant(grantId);
        return ResponseEntity.ok().build();
    }

}
