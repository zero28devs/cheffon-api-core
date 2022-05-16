package com.cheffon.api.application.services.ratings;

import com.cheffon.api.application.services.ratings.interfaces.RatingApplicationService;
import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.repositories.RatingRepository;
import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;

import com.cheffon.api.shared.exceptions.application.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RatingAppService implements RatingApplicationService {

    private final RatingRepository<Page<Rating>,Pageable> ratingRepository;

    @Autowired
    public RatingAppService( RatingRepository<Page<Rating>, Pageable> ratingRepository ) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating buscar(Long id) throws RecursoNaoEncontradoException {
        Rating rating = ratingRepository.buscar( id );
        if( rating == null )
            throw new RecursoNaoEncontradoException( Rating.class );
        return rating;
    }

    @Override
    public Page<Rating> listar(Pageable dadosPaginacao, ListarRatingFiltro filtro) {
        return ratingRepository.listar(dadosPaginacao, filtro);
    }

    @Override
    public Rating cadastrar(Rating rating) {
        return ratingRepository.cadastrar(rating);
    }

    @Override
    public Rating editar(Long id, Rating rating) {
        rating.setId(id);
        return ratingRepository.editar(rating);
    }

    @Override
    public void excluir(Long id) {
        ratingRepository.excluir(id);
    }
}
