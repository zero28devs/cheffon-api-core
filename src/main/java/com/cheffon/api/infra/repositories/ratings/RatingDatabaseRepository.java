package com.cheffon.api.infra.repositories.ratings;

import com.cheffon.api.application.mapings.ratings.RatingMappper;
import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.repositories.RatingRepository;
import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;
import com.cheffon.api.infra.db.jpa.ratings.RatingDataRepository;
import com.cheffon.api.infra.db.orm.ratings.RatingData;
import com.cheffon.api.infra.db.orm.ratings.RatingDataSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingDatabaseRepository implements RatingRepository<Page<Rating>, Pageable> {

    private final RatingDataRepository ratingDataRepository;

    @Autowired
    public RatingDatabaseRepository(RatingDataRepository ratingDataRepository) {
        this.ratingDataRepository = ratingDataRepository;
    }

    @Override
    public Rating buscar(Long id) {
        RatingData ratingData = ratingDataRepository.findById(id).orElse(null);
        return RatingMappper.INSTANCE.ratingDataToRating(ratingData);
    }

    @Override
    public Page<Rating> listar(Pageable dadosPaginacao, ListarRatingFiltro filtro) {
        RatingDataSpecification ratingDataSpecification = new RatingDataSpecification( filtro );
        Page<RatingData> ratingsDatasPagina = ratingDataRepository.findAll( ratingDataSpecification, dadosPaginacao );
        List<Rating> ratings = ratingsDatasPagina.getContent().stream().map(RatingMappper.INSTANCE::ratingDataToRating).toList();
        return new PageImpl<>( ratings, dadosPaginacao, ratingsDatasPagina.getTotalElements() );
    }

    @Override
    public Rating cadastrar(Rating rating) {
        return persistirRating(rating);
    }

    @Override
    public Rating editar(Rating rating) {
        return persistirRating(rating);
    }

    @Override
    public void excluir(Long codigo) {
        ratingDataRepository.deleteById(codigo);
    }

    private Rating persistirRating(Rating rating){
        RatingData ratingData = RatingMappper.INSTANCE.ratingToRatingData(rating);
        RatingData ratingDataSalva = ratingDataRepository.save(ratingData);
        return RatingMappper.INSTANCE.ratingDataToRating(ratingDataSalva);
    }
}
