package com.qaracter.services.impl;


import com.qaracter.entities.GrantEntity;
import com.qaracter.entities.RoleEntity;
import com.qaracter.mappers.GrantMapper;
import com.qaracter.mappers.RoleMapper;
import com.qaracter.models.Grant;
import com.qaracter.models.Role;
import com.qaracter.repositories.GrantRepository;
import com.qaracter.repositories.RoleRepository;
import com.qaracter.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final GrantRepository grantRepository;

   public RoleServiceImpl(RoleRepository roleRepository, GrantRepository grantRepository) {
        this.roleRepository = roleRepository;
        this.grantRepository = grantRepository;
    }

    @Override
    public Role createRole(Role role) {
        RoleEntity entity = RoleMapper.toEntity(role);
        return RoleMapper.toModel(roleRepository.save(entity));
    }

    @Override
    public Role getRoleById(Integer id) {
        Optional<RoleEntity> optEntity = roleRepository.findById(id);
        if(optEntity.isPresent()) {
            return RoleMapper.toModel(optEntity.get());
        }
        throw new RuntimeException("Role not found with id: " + id);
    }

    @Override
    public Set<Role> getAllRoles() {
        List<RoleEntity> entities = roleRepository.findAll();
        return entities.stream().map(RoleMapper::toModel).collect(Collectors.toSet());
    }

    @Override
    public Role updateRole(Integer roleId, Role role) {
        RoleEntity entity = RoleMapper.toEntity(role);
        if (role.getId() != null && roleRepository.existsById(role.getId())) {
            return RoleMapper.toModel(roleRepository.save(entity));
        }
        throw new RuntimeException("Role not found with id: " + role.getId());
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Grant createGrant(Grant grant) {
        GrantEntity grantEntity = GrantMapper.toEntity(grant);
        return GrantMapper.toModel(grantRepository.save(grantEntity));
    }

    @Override
    public Role addGrantToRole(Integer roleId, Grant grant) {
        Optional<RoleEntity> optEntity = roleRepository.findById(roleId);
        if(optEntity.isPresent()) {
            RoleEntity roleEntity = optEntity.get();
            GrantEntity grantEntity = GrantMapper.toEntity(grant);
            RoleService.serveGrantRole('a', roleEntity, grantEntity);
            grantRepository.save(grantEntity);
            return RoleMapper.toModel(roleRepository.save(roleEntity));
        }
        throw new RuntimeException("Role not found with id: " + roleId);
    }

    @Override
    public Role removeGrantFromRole(Integer roleId, Integer grantId) {
        Optional<RoleEntity> optRole = roleRepository.findById(roleId);
        Optional<GrantEntity> optGrant = grantRepository.findById(grantId);
        if(optRole.isPresent() && optGrant.isPresent()) {
            RoleEntity roleEntity = optRole.get();
            GrantEntity grantEntity = optGrant.get();
            RoleService.serveGrantRole('r', roleEntity, grantEntity);
            grantRepository.save(grantEntity);
            return RoleMapper.toModel(roleRepository.save(roleEntity));
        }
        throw new RuntimeException("Role not found with id: " + roleId);
    }

    @Override
    public Set<Grant> getGrantsByRoleId(Integer roleId) {
        Optional<RoleEntity> role = roleRepository.findById(roleId);
        if(role.isPresent()){
            return role.get().getGrants().stream().map(GrantMapper::toModel).collect(Collectors.toSet());
        }
        throw new RuntimeException("Role not found with id: " + roleId);
    }

    public void deleteGrant(Integer grantId) {
       grantRepository.deleteById(grantId);
    }

    public Grant getGrantById(Integer grantId) {
        Optional<GrantEntity> optionalGrant = grantRepository.findById(grantId);
        if(optionalGrant.isPresent()){
            return GrantMapper.toModel(optionalGrant.get());
        }
        throw new RuntimeException("Grant not found with id: " + grantId);
    }

}
