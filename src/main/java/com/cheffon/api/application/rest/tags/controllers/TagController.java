package com.cheffon.api.application.rest.tags.controllers;

import com.cheffon.api.application.mapings.tags.ListarTagFiltroMapper;
import com.cheffon.api.application.mapings.tags.TagMapper;
import com.cheffon.api.application.rest.tags.requests.TagCadastrarRequest;
import com.cheffon.api.application.rest.tags.requests.TagEditarRequest;
import com.cheffon.api.application.rest.tags.requests.TagListarRequest;
import com.cheffon.api.application.rest.tags.responses.TagResponse;
import com.cheffon.api.application.services.tags.interfaces.TagApplicationService;
import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping( "tags" )
public class TagController {

	private final TagApplicationService tagApplicationService;

	@Autowired
	public TagController( TagApplicationService tagApplicationService ) {
		this.tagApplicationService = tagApplicationService;
	}

	@GetMapping( "{id}" )
	@Operation( summary = "Recupera uma tag", description = "", tags = { "tags" } )
	public ResponseEntity<TagResponse> buscar( @PathVariable Long id ) throws RecursoNaoEncontradoException {
		Tag tag = tagApplicationService.buscar( id );
		return ResponseEntity.ok( TagMapper.INSTANCE.tagToTagResponse( tag ) );
	}

	@GetMapping
	@Operation( summary = "Lista as tags", description = "", tags = { "tags" } )
	public Page<TagResponse> listar( @PageableDefault Pageable dadosPaginacao, TagListarRequest request ) throws Exception {
		ListarTagFiltro listarTagFiltro = request != null ? ListarTagFiltroMapper.INSTANCE.tagListarRequestToListarTagFiltro( request ) : new ListarTagFiltro();
		Page<Tag> paginaTags = tagApplicationService.listar( dadosPaginacao, listarTagFiltro );
		List<TagResponse> tagsResponses = paginaTags.getContent().stream().map( TagMapper.INSTANCE::tagToTagResponse ).toList();
		return new PageImpl<>( tagsResponses, dadosPaginacao, paginaTags.getTotalElements() );
	}

	@PostMapping
	@Operation( summary = "Cadastra uma tag", description = "", tags = { "tags" } )
	public ResponseEntity<TagResponse> cadastrar( @RequestBody @Valid TagCadastrarRequest request, UriComponentsBuilder uriBuilder ) {
		Tag tag = TagMapper.INSTANCE.tagCadastrarRequestToTag( request );
		Tag tagCadastrada = tagApplicationService.cadastrar( tag );
		URI uri = uriBuilder.path( "/tags/{id}" ).buildAndExpand( tagCadastrada.getId() ).toUri();
		return ResponseEntity.created( uri ).body( TagMapper.INSTANCE.tagToTagResponse( tagCadastrada ) );
	}

	@PutMapping( "{id}" )
	@Operation( summary = "Edita uma tag", description = "", tags = { "tags" } )
	public ResponseEntity<TagResponse> editar( @PathVariable Long id, @RequestBody @Valid TagEditarRequest request ) {
		Tag tag = TagMapper.INSTANCE.tagEditarRequestToTag( request );
		Tag tagEditada = tagApplicationService.editar( id, tag );
		return ResponseEntity.ok( TagMapper.INSTANCE.tagToTagResponse( tagEditada ) );
	}

	@DeleteMapping( "{id}" )
	@Operation( summary = "Exclui uma tag", description = "", tags = { "tags" } )
	public ResponseEntity<Void> excluir( @PathVariable Long id ) {
		tagApplicationService.excluir( id );
		return ResponseEntity.noContent().build();
	}
}
