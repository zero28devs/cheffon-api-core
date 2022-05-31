package com.cheffon.api.domain.action.factories;

import com.cheffon.api.domain.action.entities.Action;

public final class ActionFactory {
    public Action gerarPadrao(){
        return new Action("teste");
    }
}
