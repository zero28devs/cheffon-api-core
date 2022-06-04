package com.cheffon.api.application.ioc.action;


import com.cheffon.api.application.services.action.ActionAppService;
import com.cheffon.api.application.services.action.interfaces.ActionApplicationService;
import com.cheffon.api.domain.action.entities.Action;
import com.cheffon.api.domain.action.repositories.ActionRepository;
import com.cheffon.api.domain.action.services.ActionService;
import com.cheffon.api.domain.action.services.interfaces.ActionDomainService;
import com.cheffon.api.infra.db.jpa.action.ActionDataRepository;
import com.cheffon.api.infra.repositories.action.ActionDatabaseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Configuration
public class ActionBeanConfiguration {

    @Bean
    public ActionRepository<Page<Action>, Pageable> actionRepository(ActionDataRepository actionDataRepository){
        return new ActionDatabaseRepository(actionDataRepository);
    }

    @Bean
    public ActionDomainService actionDomainService(ActionRepository<Page<Action>, Pageable> actionRepository){
        return new ActionService<>(actionRepository);
    }

    @Bean
    public ActionApplicationService actionApplicationService(ActionRepository<Page<Action>, Pageable> actionRepository){
        return new ActionAppService(actionRepository);
    }
}
