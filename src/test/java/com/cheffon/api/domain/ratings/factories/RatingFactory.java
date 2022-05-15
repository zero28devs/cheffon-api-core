package com.cheffon.api.domain.ratings.factories;

import com.cheffon.api.domain.rating.entities.Rating;

public final class RatingFactory {
    public Rating gerarPadrao(){ return  new Rating(1.0);}
}
