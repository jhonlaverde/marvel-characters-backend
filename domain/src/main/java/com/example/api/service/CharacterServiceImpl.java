package com.example.api.service;

import com.example.api.model.HistoryDto;
import com.example.api.model.ResultDto;
import com.example.api.ports.api.CharacterServicePort;
import com.example.api.ports.spi.HeroesServicePort;
import com.example.api.ports.spi.HistoryPersistencePort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CharacterServiceImpl implements CharacterServicePort {

    private final HistoryPersistencePort historyPersistencePort;
    private final HeroesServicePort heroesServicePort;

    public CharacterServiceImpl(HistoryPersistencePort historyPersistencePort, HeroesServicePort heroesServicePort) {
        this.historyPersistencePort = historyPersistencePort;
        this.heroesServicePort = heroesServicePort;
    }
    @Override
    public List<ResultDto> getHeroes(String uri) {
        var heroes = heroesServicePort.getAllHeroes();
        if(heroes != null){
            var dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            var historyDto = HistoryDto.builder().date(dateTime).request(uri).build();
            historyPersistencePort.addHistory(historyDto);
        }
        return heroes;
    }

    @Override
    public ResultDto getHeroById(String id, String uri) {
        var hero = heroesServicePort.getHero(id);
        if(hero != null){
            var dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            var historyDto = HistoryDto.builder().date(dateTime).request(uri).build();
            historyPersistencePort.addHistory(historyDto);
        }
        return hero;
    }
}
