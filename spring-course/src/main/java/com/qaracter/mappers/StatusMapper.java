package com.qaracter.mappers;

import com.qaracter.entities.StatusEntity;
import com.qaracter.models.Status;

public class StatusMapper {

    public static StatusEntity toEntity(Status status) {
        return new StatusEntity(status.getId(), status.getStatusName());
    }

    public static Status toModel(StatusEntity statusEntity) {
        return new Status(statusEntity.getId(), statusEntity.getStatusName());
    }
    
}
