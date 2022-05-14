package com.cheffon.api.infra.db.orm.ratings;

import com.cheffon.api.domain.rating.services.filtros.ListarRatingFiltro;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public final class RatingDataSpecification implements Specification<RatingData> {

    private ListarRatingFiltro listarRatingFiltro;

    public RatingDataSpecification(ListarRatingFiltro listarRatingFiltro){
        this.listarRatingFiltro = listarRatingFiltro;
    }

    @Override
    public Predicate toPredicate(Root<RatingData> root, @Nullable CriteriaQuery<?> query, CriteriaBuilder builder) {
        if( listarRatingFiltro.getScore() != null)
            return builder.like( root.get( "score" ), "%" + listarRatingFiltro.getScore() + "%" );
        return null;
    }
}
