package com.cheffon.api.application.mapings.tags;

import com.cheffon.api.application.rest.tags.requests.TagListarRequest;
import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ListarTagFiltroMapper {

	ListarTagFiltroMapper INSTANCE = Mappers.getMapper( ListarTagFiltroMapper.class );

	ListarTagFiltro tagListarRequestToListarTagFiltro( TagListarRequest request );
}
