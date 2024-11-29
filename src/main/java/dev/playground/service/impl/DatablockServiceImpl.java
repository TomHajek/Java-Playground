package dev.playground.service.impl;

import dev.playground.persistence.dto.DatablockDto;
import dev.playground.persistence.dto.RefreshResponse;
import dev.playground.persistence.entity.Datablock;
import dev.playground.persistence.repository.DatablockRepository;
import dev.playground.service.DatablockService;
import dev.playground.service.SchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class DatablockServiceImpl implements DatablockService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatablockServiceImpl.class);

    private final DatablockRepository datablockRepository;
    private final SchedulerService schedulerService;


    @Autowired
    public DatablockServiceImpl(DatablockRepository datablockRepository, SchedulerService schedulerService) {
        this.datablockRepository = datablockRepository;
        this.schedulerService = schedulerService;
    }

    @Override
    public DatablockDto createDatablock(DatablockDto datablockDto) {
        LOGGER.info("Create new data block");
        Datablock datablock = new Datablock();
        datablock.setName(datablockDto.getName());
        datablock.setAddress(datablockDto.getAddress());
        datablock.setRefreshInterval(datablock.getRefreshInterval());
        // save new data block in db
        datablockRepository.save(datablock);

        // schedule refresh for new data block
        schedulerService.scheduleJob(datablock.getId());

        return new DatablockDto().of(datablock);
    }

    @Override
    public DatablockDto updateDatablock(Integer id, DatablockDto datablockDto) {
        LOGGER.info("Update existing data block");
        Datablock datablock = fetchDatablockById(id).get();

        //update data block
        datablock.setName(datablockDto.getName());
        datablock.setAddress(datablockDto.getAddress());
        datablock.setRefreshInterval(datablockDto.getRefreshInterval());
        datablockRepository.save(datablock);

        //update existing job and trigger
        schedulerService.updateJob(id, true);

        return new DatablockDto().of(datablock);
    }

    @Override
    public void deleteDatablock(Integer id) {
        LOGGER.info("Delete existing data block");
        Datablock datablock = fetchDatablockById(id).get();

        //first, remove job from scheduler
        schedulerService.deleteJob(datablock.getId());

        //then, remove the object
        datablockRepository.deleteById(id);
    }

    /**
     * For demo purpose, we just fetch data from db,
     * but in real world scenario we can do various operations with the data.
     */
    @Override
    public RefreshResponse refreshDatablock(Integer id) {
        LOGGER.info("Refresh data block");
        Datablock datablock = fetchDatablockById(id).get();
        datablock.setLastRefreshAt(Instant.now());
        datablockRepository.save(datablock);

        return new RefreshResponse().of(datablock);
    }

    private Optional<Datablock> fetchDatablockById(Integer id) {
        LOGGER.info("Fetch data block by id");
        return Optional.of(datablockRepository.findById(id).orElseThrow(() -> {
            LOGGER.error("Id not found!");
            return new EmptyResultDataAccessException(0);
        }));
    }

}
