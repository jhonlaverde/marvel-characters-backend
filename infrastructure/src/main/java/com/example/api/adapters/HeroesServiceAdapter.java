package com.example.api.adapters;

import com.example.api.model.ResultDto;
import com.example.api.mappers.CharacterMapper;
import com.example.api.ports.spi.HeroesServicePort;
import com.services.restclient.interfaces.MarvelApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroesServiceAdapter implements HeroesServicePort {

    @Autowired
    private MarvelApi marvelApi;

    @Override
    public List<ResultDto> getAllHeroes() {
        var response = marvelApi.getCharacters();
        return CharacterMapper.INSTANCE.listResultToResultDto(response);
    }

    @Override
    public ResultDto getHero(String id) {
        var response = marvelApi.getCharacterById(id);
        return CharacterMapper.INSTANCE.resultToResultDto(response);
    }
}
