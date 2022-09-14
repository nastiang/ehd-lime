package com.farzoom.ehd.config;

import com.farzoom.common.persistence.es.repositories.*;
import com.farzoom.common.persistence.es.repositories.base.EsRepositoryFactory;
import com.farzoom.common.persistence.es.repositories.base.EsVersion;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "es")
public class EsConfig {
    @Setter
    private String baseUrl;

    public void setVersion(EsVersion version) {
        EsRepositoryFactory.configureVersion(version);
    }

    @Bean
    public OrderRepository esOrderRepository(){ return new OrderRepository(baseUrl); }

    @Bean
    public CompanyRepository esProductRepository() {
        return new CompanyRepository(baseUrl);
    }

    @Bean
    public PersonRepository esPersonRepository() {
        return new PersonRepository(baseUrl);
    }

}
