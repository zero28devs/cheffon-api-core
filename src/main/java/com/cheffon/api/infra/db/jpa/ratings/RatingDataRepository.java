package com.cheffon.api.infra.db.jpa.ratings;

import com.cheffon.api.infra.db.orm.ratings.RatingData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingDataRepository extends PagingAndSortingRepository<RatingData, Long>, JpaSpecificationExecutor<RatingData> {
}
