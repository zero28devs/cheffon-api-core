package com.cheffon.api.infra.repositories.action;
import com.cheffon.api.application.mapings.action.ActionMapper;
import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.domain.action.repositories.ActionRepository;
import com.cheffon.api.domain.action.services.filtros.ListarActionFiltro;
import com.cheffon.api.infra.db.jpa.action.ActionDataRepository;
import com.cheffon.api.infra.db.orm.action.ActionData;
import com.cheffon.api.infra.db.orm.action.ActionDataSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ActionDatabaseRepository implements ActionRepository<Page<Action>, Pageable> {

    private ActionDataRepository actionDataRepository;

    @Autowired
    public ActionDatabaseRepository(ActionDataRepository actionDataRepository) {
        this.actionDataRepository = actionDataRepository;
    }

    @Override
    public Action buscar(Long id) {
        ActionData actionData = actionDataRepository.findById(id).orElse(null);
        return ActionMapper.INSTANCE.actionDataToAction(actionData);
    }

    @Override
    public Page<Action> listar(Pageable dadosPaginacao, ListarActionFiltro filtro) {
        ActionDataSpecification actionDataSpecification = new ActionDataSpecification(filtro);
        Page<ActionData> actionsDatasPagina = actionDataRepository.findAll(actionDataSpecification, dadosPaginacao);
        List<Action> actions = actionsDatasPagina.getContent().stream().map(ActionMapper.INSTANCE::actionDataToAction).toList();
        return new PageImpl<>(actions, dadosPaginacao,actionsDatasPagina.getTotalElements());
    }

    @Override
    public Action cadastrar(Action action) {
        return persistirAction(action);
    }

    @Override
    public Action editar(Action action) {
        return persistirAction(action);
    }

    @Override
    public void excluir(Long codigo) {
        actionDataRepository.deleteById(codigo);
    }
    private Action persistirAction(Action action ) {
        ActionData actionData = ActionMapper.INSTANCE.actionToActionData( action );
        ActionData actionDataSalva = actionDataRepository.save( actionData );
        return ActionMapper.INSTANCE.actionDataToAction(actionDataSalva);
    }
}
