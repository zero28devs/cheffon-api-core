package com.cheffon.api.application.mapings.action;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActionMapper {
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

}
