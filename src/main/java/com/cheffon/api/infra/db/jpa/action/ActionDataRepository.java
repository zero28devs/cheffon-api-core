package com.cheffon.api.infra.db.jpa.action;

import com.cheffon.api.infra.db.orm.action.ActionData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActionDataRepository extends PagingAndSortingRepository<ActionData, Long>, JpaSpecificationExecutor<ActionData> {
}
