package com.cheffon.api.application.rest.tags.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record TagEditarRequest(@NotNull @NotEmpty String nome) {

}
