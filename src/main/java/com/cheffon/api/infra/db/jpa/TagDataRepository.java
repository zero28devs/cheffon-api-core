package com.cheffon.api.infra.db.jpa;

import com.cheffon.api.domain.tags.services.filtros.ListarTagFiltro;
import com.cheffon.api.infra.db.orm.TagData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDataRepository extends PagingAndSortingRepository<TagData, Long>, JpaSpecificationExecutor<ListarTagFiltro> {

}
