package com.example.api.ports.api;

import com.example.api.model.HistoryDto;
import com.example.api.model.ResultDto;

import java.util.List;

public interface CharacterServicePort {
    List<ResultDto> getHeroes(String uri);
    ResultDto getHeroById(String id, String uri);
}
