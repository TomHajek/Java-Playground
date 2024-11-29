package dev.playground.service.impl;

import dev.playground.job.RefreshJob;
import dev.playground.persistence.entity.Datablock;
import dev.playground.persistence.repository.DatablockRepository;
import dev.playground.service.SchedulerService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerKey.triggerKey;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerServiceImpl.class);

    private final Scheduler scheduler;
    private final DatablockRepository datablockRepository;


    @Autowired
    public SchedulerServiceImpl(Scheduler scheduler, DatablockRepository datablockRepository) {
        this.scheduler = scheduler;
        this.datablockRepository = datablockRepository;
    }

    /**
     * Tells quartz to schedule the job using job trigger
     */
    @Override
    public void scheduleJob(Integer id) {
        LOGGER.info("Scheduling refresh job {}", id);
        Datablock datablock = getJobById(id);
        JobDetail jobDetail = buildJobDetail(datablock);
        Trigger trigger = buildJobTrigger(jobDetail, datablock);

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Replace(overwrites) existing job
     */
    @Override
    public void updateJob(Integer id, Boolean replace) {
        LOGGER.info("Updating refresh job {}", id);
        Datablock datablock = getJobById(id);
        JobDetail jobDetail = buildJobDetail(datablock);
        Trigger trigger = buildJobTrigger(jobDetail, datablock);

        try {
            //replacing old job
            scheduler.addJob(jobDetail, true);

            //replacing old trigger
            scheduler.rescheduleJob(triggerKey(datablock.getId().toString(), datablock.getName()), trigger);

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Remove job completely and unschedule all of its triggers
     */
    @Override
    public void deleteJob(Integer id) {
        LOGGER.info("Removing refresh job {}", id);
        Datablock datablock = getJobById(id);

        try {
            if (scheduler.deleteJob(jobKey(datablock.getId().toString(), datablock.getName()))) {
                LOGGER.info("Refresh job '{}' has been successfully removed", jobKey(datablock.getId().toString()));
            } else {
                LOGGER.error("Failed to remove refresh job '{}'", jobKey(datablock.getId().toString()));
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Fetch job by id
     */
    @Override
    public Datablock getJobById(Integer id) {
        LOGGER.info("Get data block by id");
        return datablockRepository.findById(id).orElseThrow(
                () -> new EmptyResultDataAccessException("Data block not found.", 0)
        );
    }

    /**
     * Define job detail and tie it to the job class (defining instance of the job)
     */
    private JobDetail buildJobDetail(Datablock datablock) {
        LOGGER.info("Building job detail for data block: {}", datablock.getId());
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobId", datablock.getId().toString());

        return JobBuilder.newJob(RefreshJob.class)
                .withIdentity(datablock.getId().toString(), datablock.getName())
                .withDescription("Refresh data of block '" + datablock.getId().toString() + "'")
                .usingJobData(jobDataMap)
                .storeDurably(true)
                .requestRecovery(true) // if job is interrupted (for ex. by app shutdown, it will continue after restart)
                .build();
    }

    /**
     * Trigger the job to start and stop running at given time (defining the schedule upon which a given job will be executed)
     */
    private Trigger buildJobTrigger(JobDetail jobDetail, Datablock datablock) {
        LOGGER.info("Building job trigger for data block: {}", datablock.getId());
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(datablock.getId().toString(), datablock.getName())
                .withDescription("Trigger job to refresh data of block '" + datablock.getId().toString() + "'")
                .startAt(Date.from(Instant.now()))
                .withSchedule(simpleSchedule()
                        .withMisfireHandlingInstructionFireNow()
                        .withIntervalInMinutes(datablock.getRefreshInterval())
                        .repeatForever())
                .build();
    }

}
