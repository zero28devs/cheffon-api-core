package com.cheffon.api.application.mapings.ratings;

import com.cheffon.api.application.rest.ratings.requests.RatingCadastrarRequest;
import com.cheffon.api.application.rest.ratings.requests.RatingEditarRequest;
import com.cheffon.api.application.rest.ratings.responses.RatingResponse;
import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.infra.db.orm.ratings.RatingData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RatingMappper {

    RatingMappper INSTANCE = Mappers.getMapper( RatingMappper.class );

    RatingResponse ratingToRatingResponse(Rating rating);

    Rating ratingCadastrarRequestToRating(RatingCadastrarRequest requests);

    Rating ratingEditarRequestToRating(RatingEditarRequest requests);

    Rating ratingDataToRating(RatingData ratingData);

    RatingData ratingToRatingData(Rating rating);
}
