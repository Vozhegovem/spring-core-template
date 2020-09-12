package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {
    @Value("${item.repository.implementation}")
    String implementation;

    private final RepositoryConfiguration repositoryConfiguration;
    private final InitializerConfiguration initializerConfiguration;

    @Autowired
    public MainConfiguration(RepositoryConfiguration repositoryConfiguration, InitializerConfiguration initializerConfiguration) {
        this.repositoryConfiguration = repositoryConfiguration;
        this.initializerConfiguration = initializerConfiguration;
    }

    @Bean
    public ItemRepository itemRepository() {
        if (implementation.equals("linked")) {
            return repositoryConfiguration.linkedListItemRepository();
        }
        return  repositoryConfiguration.arrayListItemRepository();
    }
}
