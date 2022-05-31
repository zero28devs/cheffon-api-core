package com.cheffon.api.application.rest.action.controllers;

import com.cheffon.api.application.mapings.action.ActionMapper;
import com.cheffon.api.application.mapings.action.ListarActionFiltroMapper;
import com.cheffon.api.application.rest.action.requests.ActionCadastrarRequest;
import com.cheffon.api.application.rest.action.requests.ActionEditarRequest;
import com.cheffon.api.application.rest.action.requests.ActionListarRequest;
import com.cheffon.api.application.rest.action.responses.ActionResponse;
import com.cheffon.api.application.services.action.interfaces.ActionApplicationService;
import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.domain.action.services.filtros.ListarActionFiltro;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("actions")
public final class ActionController {

    private final ActionApplicationService actionApplicationService;

    @Autowired
    public ActionController(ActionApplicationService actionApplicationService) {
        this.actionApplicationService = actionApplicationService;
    }

    @GetMapping( "{id}" )
    @Operation( summary = "Recupera uma action", description = "", tags = { "actions" } )
    public ResponseEntity<ActionResponse> buscar(@PathVariable Long id ) throws RecursoNaoEncontradoException {
        Action action = actionApplicationService.buscar( id );
        return ResponseEntity.ok( ActionMapper.INSTANCE.actionToActionResponse( action ) );
    }

    @GetMapping
    @Operation( summary = "Lista as actions", description = "", tags = { "actions" } )
    public Page<ActionResponse> listar( @PageableDefault Pageable dadosPaginacao, ActionListarRequest request ) {
        ListarActionFiltro listarActionFiltro = request != null ? ListarActionFiltroMapper.INSTANCE.actionListarRequestToListarActionFiltro( request ) : new ListarActionFiltro();
        Page<Action> paginaActions = actionApplicationService.listar( dadosPaginacao, listarActionFiltro );
        List<ActionResponse> actionsResponses = paginaActions.getContent().stream().map( ActionMapper.INSTANCE::actionToActionResponse ).toList();
        return new PageImpl<>( actionsResponses, dadosPaginacao, paginaActions.getTotalElements() );
    }

    @PostMapping
    @Operation( summary = "Cadastra uma action", description = "", tags = { "actions" } )
    public ResponseEntity<ActionResponse> cadastrar(@RequestBody @Valid ActionCadastrarRequest request, UriComponentsBuilder uriBuilder ) {
        Action action = ActionMapper.INSTANCE.actionCadastrarRequestToAction( request );
        Action actionCadastrada = actionApplicationService.cadastrar( action );
        URI uri = uriBuilder.path( "/Actions/{id}" ).buildAndExpand( actionCadastrada.getId() ).toUri();
        return ResponseEntity.created( uri ).body( ActionMapper.INSTANCE.actionToActionResponse( actionCadastrada ) );
    }

    @PutMapping( "{id}" )
    @Operation( summary = "Edita uma action", description = "", tags = { "actions" } )
    public ResponseEntity<ActionResponse> editar( @PathVariable Long id, @RequestBody @Valid ActionEditarRequest request ) {
        Action action = ActionMapper.INSTANCE.actionEditarRequestToAction( request );
        Action actionEditada = actionApplicationService.editar( id, action );
        return ResponseEntity.ok( ActionMapper.INSTANCE.actionToActionResponse( actionEditada ) );
    }

    @DeleteMapping( "{id}" )
    @Operation( summary = "Exclui uma action", description = "", tags = { "actions" } )
    public ResponseEntity<Void> excluir( @PathVariable Long id ) {
        actionApplicationService.excluir( id );
        return ResponseEntity.noContent().build();
    }
}
