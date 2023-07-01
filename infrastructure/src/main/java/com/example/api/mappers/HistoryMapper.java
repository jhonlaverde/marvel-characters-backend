package com.example.api.mappers;

import com.example.api.entity.History;
import com.example.api.model.HistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HistoryMapper {
    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);

    //@Mapping(target = "date", source = "historyDto.date")
    //@Mapping(target = "request", source = "historyDto.request")
    History historyDtoToHistory(HistoryDto historyDto);

    HistoryDto historyToHistoryDto(History history);
}
