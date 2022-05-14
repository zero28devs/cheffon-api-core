package com.cheffon.api.application.ioc.ratings;

import com.cheffon.api.application.services.ratings.RatingAppService;
import com.cheffon.api.application.services.ratings.interfaces.RatingApplicationService;
import com.cheffon.api.domain.rating.repositories.RatingRepository;
import com.cheffon.api.domain.rating.entities.Rating;
import com.cheffon.api.domain.rating.services.RatingService;
import com.cheffon.api.domain.rating.services.interfaces.RatingDomainService;
import com.cheffon.api.infra.db.jpa.ratings.RatingDataRepository;
import com.cheffon.api.infra.repositories.ratings.RatingDatabaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Configuration
public class RatingBeanConfiguration {

    @Bean
    public RatingRepository<Page<Rating>, Pageable> ratingRepository(RatingDataRepository ratingDataRepository){
        return new RatingDatabaseRepository(ratingDataRepository);
    }

    @Bean
    public RatingDomainService ratingDomainService(RatingRepository<Page<Rating>, Pageable> ratingRepository){
        return new RatingService<>(ratingRepository);
    }

    @Bean
    public RatingApplicationService ratingApplicationService(RatingRepository<Page<Rating>, Pageable> ratingRepository){
        return new RatingAppService(ratingRepository);
    }
}
