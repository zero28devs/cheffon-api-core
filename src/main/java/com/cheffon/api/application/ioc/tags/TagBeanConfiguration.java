package com.cheffon.api.application.ioc.tags;

import com.cheffon.api.application.services.tags.TagAppService;
import com.cheffon.api.application.services.tags.interfaces.TagApplicationService;
import com.cheffon.api.domain.tags.entities.Tag;
import com.cheffon.api.domain.tags.repositories.TagRepository;
import com.cheffon.api.domain.tags.services.TagService;
import com.cheffon.api.domain.tags.services.interfaces.TagDomainService;
import com.cheffon.api.infra.db.jpa.TagDataRepository;
import com.cheffon.api.infra.repositories.tags.TagDatabaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Configuration
public class TagBeanConfiguration {

	@Bean
	public TagRepository<Page<Tag>, Pageable> tagRepository( TagDataRepository tagDataRepository ) {
		return new TagDatabaseRepository( tagDataRepository );
	}

	@Bean
	public TagDomainService tagDomainService( TagRepository<Page<Tag>, Pageable> tagRepository ) {
		return new TagService<Page<Tag>, Pageable>( tagRepository );
	}

	@Bean
	public TagApplicationService tagApplicationService( TagRepository<Page<Tag>, Pageable> tagRepository ) {
		return new TagAppService( tagRepository );
	}
}
