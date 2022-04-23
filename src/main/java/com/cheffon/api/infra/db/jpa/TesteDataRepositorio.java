package com.cheffon.api.infra.db.jpa;

import com.cheffon.api.infra.db.orm.TesteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TesteDataRepositorio extends PagingAndSortingRepository<TesteData, Long> {
}
