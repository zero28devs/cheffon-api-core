package com.cheffon.api.application.mapings.ratings;


import com.cheffon.api.application.rest.ratings.requests.RatingListarRequest;
import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ListarRatingFiltroMapper {

    ListarRatingFiltroMapper INSTANCE = Mappers.getMapper(ListarRatingFiltroMapper.class);

    ListarRatingFiltro ratingListarRequestToListarRatingFiltro(RatingListarRequest request);
}
