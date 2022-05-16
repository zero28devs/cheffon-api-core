package com.cheffon.api.application.services.ratings.interfaces;

import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;
import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RatingApplicationService {

    Rating buscar(Long id ) throws RecursoNaoEncontradoException;

    Page<Rating> listar(Pageable dadosPaginacao, ListarRatingFiltro filtro );

    Rating cadastrar( Rating rating );

    Rating editar( Long id, Rating rating );

    void excluir( Long id );
}
