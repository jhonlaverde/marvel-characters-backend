package com.example.api.ports.spi;

import com.example.api.model.ResultDto;

import java.util.List;

public interface HeroesServicePort {
    List<ResultDto> getAllHeroes();
    ResultDto getHero(String id);
}
