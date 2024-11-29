package dev.playground.service;

import dev.playground.persistence.entity.Datablock;

public interface SchedulerService {

    void scheduleJob(Integer id);
    void updateJob(Integer id, Boolean replace);
    void deleteJob(Integer id);
    Datablock getJobById(Integer id);

}
