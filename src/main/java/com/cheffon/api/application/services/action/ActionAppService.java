package com.cheffon.api.application.services.action;

import com.cheffon.api.application.services.action.interfaces.ActionApplicationService;
import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.domain.action.repositories.ActionRepository;
import com.cheffon.api.domain.action.services.filtros.ListarActionFiltro;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public final class ActionAppService implements ActionApplicationService {

    private final ActionRepository<Page<Action>, Pageable> actionRepository;

    @Autowired
    public ActionAppService(ActionRepository<Page<Action>, Pageable> actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public Action buscar(Long id) throws RecursoNaoEncontradoException {
        Action action = actionRepository.buscar(id);
        if(action == null)
            throw new RecursoNaoEncontradoException(Action.class);
        return action;
    }

    @Override
    public Page<Action> listar(Pageable dadosPaginacao, ListarActionFiltro filtro) {
        return actionRepository.listar(dadosPaginacao,filtro);
    }

    @Override
    public Action cadastrar(Action action) {
        return actionRepository.cadastrar(action);
    }

    @Override
    public Action editar(Long id, Action action) {
        action.setId(id);
        return actionRepository.editar(action);
    }

    @Override
    public void excluir(Long id) {
        actionRepository.excluir(id);
    }
}
