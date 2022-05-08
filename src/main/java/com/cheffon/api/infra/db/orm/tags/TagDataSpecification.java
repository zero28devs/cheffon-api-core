package com.cheffon.api.infra.db.orm.tags;

import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TagDataSpecification implements Specification<TagData> {

	private ListarTagFiltro listarTagFiltro;

	public TagDataSpecification( ListarTagFiltro listarTagFiltro ) {
		this.listarTagFiltro = listarTagFiltro;
	}

	@Override
	public Predicate toPredicate( Root<TagData> root, @Nullable CriteriaQuery<?> query, CriteriaBuilder builder ) {
		if( listarTagFiltro.getNome() != null && !listarTagFiltro.getNome().isEmpty() )
			return builder.like( root.get( "nome" ), "%" + listarTagFiltro.getNome() + "%" );
		return null;
	}
}
