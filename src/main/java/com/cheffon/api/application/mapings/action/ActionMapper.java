package com.cheffon.api.application.mapings.action;

import com.cheffon.api.application.rest.action.requests.ActionCadastrarRequest;
import com.cheffon.api.application.rest.action.requests.ActionEditarRequest;
import com.cheffon.api.application.rest.action.responses.ActionResponse;
import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.infra.db.orm.action.ActionData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActionMapper {
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    ActionResponse actionToActionResponse(Action action);

    Action actionCadastrarRequestToAction(ActionCadastrarRequest request);

    Action actionEditarRequestToAction(ActionEditarRequest request);

    Action actionDataToAction(ActionData actionData);

    ActionData actionToActionData(Action action);

}
