package dev.playground.job;

import dev.playground.service.DatablockService;
import lombok.RequiredArgsConstructor;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

@RequiredArgsConstructor
public class RefreshJob extends QuartzJobBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshJob.class);

    private final DatablockService datablockService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        LOGGER.info("Executing job");
        JobDataMap jobDataMap = context.getMergedJobDataMap();

        datablockService.refreshDatablock(Integer.parseInt(jobDataMap.getString("jobId")));
    }

}
