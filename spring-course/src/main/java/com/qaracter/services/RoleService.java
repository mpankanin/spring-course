package com.qaracter.services;

import com.qaracter.entities.GrantEntity;
import com.qaracter.entities.RoleEntity;
import com.qaracter.models.Grant;
import com.qaracter.models.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RoleService {

    public Role createRole(Role role);

    public Role getRoleById(Integer id);

    public Set<Role> getAllRoles();

    public Role updateRole(Integer roleId, Role role);

    public void deleteRole(Integer id);

    public Set<Grant> getGrantsByRoleId(Integer roleId);

    public Grant getGrantById(Integer grantId);

    public void deleteGrant(Integer grantId);

    public Grant createGrant(Grant grant);

    public Role addGrantToRole(Integer roleId, Grant grant);

    public Role removeGrantFromRole(Integer roleId, Integer grantId);

    static void serveGrantRole(char operationType, RoleEntity roleEntity, GrantEntity grantEntity) {
        Set<RoleEntity> roles = grantEntity.getRoles();
        Set<GrantEntity> grants = roleEntity.getGrants();
        switch (operationType){
            case 'a' -> {
                roles.add(roleEntity);
                grants.add(grantEntity);
            }
            case 'r' -> {
                roles.remove(roleEntity);
                grants.remove(grantEntity);
            }
            default -> throw new RuntimeException("Wrong operation code");
        }
        roleEntity.setGrants(grants);
        grantEntity.setRoles(roles);
    }

}


