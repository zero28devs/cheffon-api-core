package com.cheffon.api.application.rest.ratings.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record RatingCadastrarRequest(@NotNull @NotEmpty Double score){
}
