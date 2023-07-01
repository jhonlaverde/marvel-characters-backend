package com.example.api.adapters;

import com.example.api.mappers.HistoryMapper;
import com.example.api.model.HistoryDto;
import com.example.api.ports.spi.HistoryPersistencePort;
import com.example.api.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryJpaAdapter implements HistoryPersistencePort {

    @Autowired
    private HistoryRepository historyRepository;
    @Override
    public void addHistory(HistoryDto historyDto) {
        var history = HistoryMapper.INSTANCE.historyDtoToHistory(historyDto);
        historyRepository.save(history);
    }
}
