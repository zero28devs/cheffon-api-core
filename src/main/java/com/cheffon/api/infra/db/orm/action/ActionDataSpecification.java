package com.cheffon.api.infra.db.orm.action;

import com.cheffon.api.domain.action.services.filtros.ListarActionFiltro;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public final class ActionDataSpecification implements Specification<ActionData> {

    private final ListarActionFiltro listarActionFiltro;

    public ActionDataSpecification(ListarActionFiltro listarActionFiltro) {
        this.listarActionFiltro = listarActionFiltro;
    }

    @Override
    public Predicate toPredicate(Root<ActionData> root, @Nullable CriteriaQuery<?> query, CriteriaBuilder builder ) {
        if( listarActionFiltro.getNome() != null && !listarActionFiltro.getNome().isEmpty() )
            return builder.like( root.get( "nome" ), "%" + listarActionFiltro.getNome() + "%" );
        return null;
    }
}
