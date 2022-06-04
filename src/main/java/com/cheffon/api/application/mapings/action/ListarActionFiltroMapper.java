package com.cheffon.api.application.mapings.action;

import com.cheffon.api.application.rest.action.requests.ActionListarRequest;
import com.cheffon.api.domain.action.services.filtros.ListarActionFiltro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ListarActionFiltroMapper {
    ListarActionFiltroMapper INSTANCE = Mappers.getMapper(ListarActionFiltroMapper.class);

    ListarActionFiltro actionListarRequestToListarActionFiltro(ActionListarRequest request);
}
