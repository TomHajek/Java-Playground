package dev.playground.service;

import dev.playground.persistence.dto.DatablockDto;
import dev.playground.persistence.dto.RefreshResponse;

public interface DatablockService {

    DatablockDto createDatablock(DatablockDto datablockDto);
    DatablockDto updateDatablock(Integer id, DatablockDto datablockDto);
    void deleteDatablock(Integer id);
    RefreshResponse refreshDatablock(Integer id);

}
