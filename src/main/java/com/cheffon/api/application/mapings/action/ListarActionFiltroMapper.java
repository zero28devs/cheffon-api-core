package com.cheffon.api.application.mapings.action;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ListarActionFiltroMapper {
    ListarActionFiltroMapper INSTANCE = Mappers.getMapper(ListarActionFiltroMapper.class);
}
