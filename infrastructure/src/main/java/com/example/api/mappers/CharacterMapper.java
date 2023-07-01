package com.example.api.mappers;

import com.example.api.model.ResultDto;
import com.services.restclient.model.Result;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CharacterMapper {
    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    List<ResultDto> listResultToResultDto(List<Result> result);

    ResultDto resultToResultDto(Result result);
}
