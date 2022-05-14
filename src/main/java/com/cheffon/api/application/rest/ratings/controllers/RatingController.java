package com.cheffon.api.application.rest.ratings.controllers;

import com.cheffon.api.application.mapings.ratings.ListarRatingFiltroMapper;
import com.cheffon.api.application.mapings.ratings.RatingMappper;
import com.cheffon.api.application.mapings.tags.ListarTagFiltroMapper;
import com.cheffon.api.application.mapings.tags.TagMapper;
import com.cheffon.api.application.rest.ratings.requests.RatingCadastrarRequest;
import com.cheffon.api.application.rest.ratings.requests.RatingEditarRequest;
import com.cheffon.api.application.rest.ratings.requests.RatingListarRequest;
import com.cheffon.api.application.rest.ratings.responses.RatingResponse;
import com.cheffon.api.application.rest.tags.requests.TagListarRequest;
import com.cheffon.api.application.rest.tags.responses.TagResponse;
import com.cheffon.api.application.services.ratings.interfaces.RatingApplicationService;
import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingController {

    private final RatingApplicationService ratingApplicationService;

    @Autowired
    public RatingController(RatingApplicationService ratingApplicationService) {
        this.ratingApplicationService = ratingApplicationService;
    }

    @GetMapping("{id}")
    @Operation( summary = "Recupera um rating", description = "", tags = { "ratings" } )
    public ResponseEntity<RatingResponse> buscar(@PathVariable Long id) throws RecursoNaoEncontradoException {
        Rating rating = ratingApplicationService.buscar(id);
        return ResponseEntity.ok(RatingMappper.INSTANCE.ratingToRatingResponse(rating));
    }

    @GetMapping
    @Operation( summary = "Lista os ratings", description = "", tags = { "ratings" } )
    public Page<RatingResponse> listar(@PageableDefault Pageable dadosPaginacao, RatingListarRequest request ) {
        ListarRatingFiltro listarRatingFiltro = request != null ? ListarRatingFiltroMapper.INSTANCE.ratingListarRequestToListarRatingFiltro(request):new ListarRatingFiltro();
        Page<Rating> paginaRatings = ratingApplicationService.listar(dadosPaginacao,listarRatingFiltro);
        List<RatingResponse> ratingResponses = paginaRatings.getContent().stream().map(RatingMappper.INSTANCE::ratingToRatingResponse).toList();
        return new PageImpl<>(ratingResponses,dadosPaginacao,paginaRatings.getTotalElements());
    }

    @PostMapping
    @Operation( summary = "Cadastra uma rating", description = "", tags = { "ratings" } )
    public ResponseEntity<RatingResponse> cadastrar(@RequestBody @Valid RatingCadastrarRequest request, UriComponentsBuilder uriBuilder){
        Rating rating = RatingMappper.INSTANCE.ratingCadastrarRequestToRating(request);
        Rating ratingCadastrada = ratingApplicationService.cadastrar(rating);
        URI uri = uriBuilder.path("/ratings/{id}").buildAndExpand(ratingCadastrada.getId()).toUri();
        return  ResponseEntity.created(uri).body(RatingMappper.INSTANCE.ratingToRatingResponse(ratingCadastrada));
    }

    @PutMapping
    @Operation( summary = "Edita uma rating", description = "", tags = { "ratings" } )
    public ResponseEntity<RatingResponse> editar(@PathVariable Long id, @RequestBody @Valid RatingEditarRequest request){
        Rating rating = RatingMappper.INSTANCE.ratingEditarResquestToRating(request);
        Rating ratingEditada = ratingApplicationService.editar(id,rating);
        return  ResponseEntity.ok(RatingMappper.INSTANCE.ratingToRatingResponse(ratingEditada));
    }

    @DeleteMapping( "{id}" )
    @Operation( summary = "Exclui uma rating", description = "", tags = { "ratings" } )
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        ratingApplicationService.excluir(id);
        return  ResponseEntity.noContent().build();
    }

}
