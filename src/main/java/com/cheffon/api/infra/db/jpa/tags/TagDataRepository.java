package com.cheffon.api.infra.db.jpa.tags;

import com.cheffon.api.infra.db.orm.tags.TagData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDataRepository extends PagingAndSortingRepository<TagData, Long>, JpaSpecificationExecutor<TagData> {

}
