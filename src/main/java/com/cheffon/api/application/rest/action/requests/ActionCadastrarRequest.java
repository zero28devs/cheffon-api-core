package com.cheffon.api.application.rest.action.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record ActionCadastrarRequest(@NotNull @NotEmpty String nome) {
}
