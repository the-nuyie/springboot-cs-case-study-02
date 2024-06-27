package com.training.java.springboot.casestudy.helper.quartz.job;

import com.training.java.springboot.casestudy.service.SchedulerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuartzMonitorJob implements Job  {

    Logger logger = LogManager.getLogger(QuartzMonitorJob.class);

    @Autowired
    private SchedulerService schedulerService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // do business logic here
        logger.info("==== execute() START ====");
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String jobGroup = dataMap.getString("jobGroup");
        logger.info("  jobGroup = {}", jobGroup);

        if(jobGroup.equals("MONITOR-STUDENTS")){
            logger.info("  execute monitor student");
            schedulerService.monitorStudent();
        }else if(jobGroup.equals("MONITOR-STUDENT-SCORE")){
            // do something
        }

        logger.info("==== execute() END ====");
    }

}
