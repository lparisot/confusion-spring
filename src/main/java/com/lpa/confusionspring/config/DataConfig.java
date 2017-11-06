package com.lpa.confusionspring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Slf4j
@Configuration
public class DataConfig {
    @Autowired
    private ObjectMapper jsonMapper;
    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean jackson2RepositoryPopulatorFactoryBean() {
        log.info("DataConfig::jackson2RepositoryPopulatorFactoryBean");
        Jackson2RepositoryPopulatorFactoryBean bean = new Jackson2RepositoryPopulatorFactoryBean();
        try {
            bean.setMapper(jsonMapper);
            bean.setResources(resourcePatternResolver.getResources("classpath:data/*.json"));
            bean.afterPropertiesSet();
        } catch(Exception e) {
            log.error("jackson2RepositoryPopulatorFactoryBean :" + e.getMessage());
        }
        return bean;
    }
}
