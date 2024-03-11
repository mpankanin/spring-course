package com.qaracter.mappers;

import com.qaracter.entities.GrantEntity;
import com.qaracter.models.Grant;

import java.util.stream.Collectors;

public class GrantMapper {

    public static GrantEntity toEntity(Grant grant){
        GrantEntity grantEntity = new GrantEntity();
        grantEntity.setGrantID(grant.getId());
        grantEntity.setDescription(grant.getDescription());
        grantEntity.setGrantName(grant.getGrantName());
        grantEntity.setRoles(grant.getRoles().stream().map(RoleMapper::toEntity).collect(Collectors.toSet()));
        return grantEntity;
    }

    public static Grant toModel(GrantEntity grantEntity){
        Grant grant = new Grant();
        grant.setId(grantEntity.getGrantID());
        grant.setDescription(grantEntity.getDescription());
        grant.setGrantName(grantEntity.getGrantName());
        grant.setRoles(grantEntity.getRoles().stream().map(RoleMapper::toModel).collect(Collectors.toSet()));
        return grant;
    }
}
