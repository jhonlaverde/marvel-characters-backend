package com.example.api.ports.spi;

import com.example.api.model.HistoryDto;

public interface HistoryPersistencePort {
    void addHistory(HistoryDto historyDto);
}
