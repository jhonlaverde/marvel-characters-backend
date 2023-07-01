package com.example.api.configuration;

import com.example.api.adapters.HeroesServiceAdapter;
import com.example.api.adapters.HistoryJpaAdapter;
import com.example.api.ports.api.CharacterServicePort;
import com.example.api.ports.spi.HeroesServicePort;
import com.example.api.ports.spi.HistoryPersistencePort;
import com.example.api.service.CharacterServiceImpl;
import com.services.restclient.interfaces.IMarvelApi;
import com.services.restclient.interfaces.MarvelApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MarvelConfig {
    @Bean
    public HeroesServicePort heroesServicePort(){
        return new HeroesServiceAdapter();
    }

    @Bean
    public HistoryPersistencePort historyPersistencePort(){
        return new HistoryJpaAdapter();
    }

    @Bean
    public CharacterServicePort characterServicePort(){
        return new CharacterServiceImpl(historyPersistencePort(), heroesServicePort());
    }

    @Bean
    public MarvelApi marvelApi(){
        return new IMarvelApi();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
