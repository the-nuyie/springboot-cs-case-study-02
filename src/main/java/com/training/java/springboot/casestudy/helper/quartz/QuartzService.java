package com.training.java.springboot.casestudy.helper.quartz;

import com.training.java.springboot.casestudy.helper.quartz.job.QuartzMonitorJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuartzService {

    Logger logger = LogManager.getLogger(QuartzService.class);

    @Autowired
    private Scheduler scheduler;


    public List<Map<String, String>> listJob() throws SchedulerException {
        List<Map<String, String>> listJob = new ArrayList<Map<String, String>>();

        for (String groupName : scheduler.getJobGroupNames()) {

            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

                Map<String, String> job = new HashMap<>();

                String jobName = jobKey.getName();
                String jobGroup = jobKey.getGroup();

                //get job's trigger
                List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                Date nextFireTime = triggers.get(0).getNextFireTime();

                job.put("jobName", jobName);
                job.put("jobGroup", jobGroup);
                job.put("nextFireTime", nextFireTime != null? nextFireTime.toString(): null);
                listJob.add(job);

                logger.debug("[jobName] : " + jobName + " [groupName] : "
                        + jobGroup + " - " + nextFireTime);
            }

        }

        return listJob;
    }

    public void scheduleJobByCron(Map<String, String> data){

        logger.info("==== createQuartzJob() START ====");
        logger.debug("  Job Data : "+data);
        String jobName = data.get("jobName");           // Example monitor-students-every-minutes-202406270721
        String jobGroup = data.get("jobGroup");         // Example MONITOR-STUDENTS
        // String jobClassName = data.get("jobClassName");
        String jobClassName = null;
        // String triggerName = data.get("triggerName");
        // String triggerGroup = data.get("triggerGroup");
        String triggerName = jobName;
        String triggerGroup = jobGroup;

        String cronExpression = data.get("cronExpression"); // Example 0 0/2 * * * ? = every 2 minutes
        String description = data.get("description");

        JobDataMap dataMap = null;
        Class jobClass = null;

        if(jobGroup.startsWith("MONITOR")){
            jobClassName = QuartzMonitorJob.class.toString();
            jobClass = QuartzMonitorJob.class;
            logger.debug("  jobClassName : "+jobClassName);

            dataMap = new JobDataMap(data);
        }

        try{

            logger.debug("  Start Create Job and Trigger.");
            JobDetail job = null;
            CronTrigger cTrig = null;

            // Key of job is jobName + jobGroup
            job = JobBuilder.newJob().ofType(jobClass)
                    .storeDurably()
                    .withIdentity(jobName, jobGroup)
                    .withDescription(description)
                    .usingJobData(dataMap)
                    .build();

            cTrig = TriggerBuilder
                    .newTrigger()
                    .forJob(job)
                    .withIdentity(triggerName, triggerGroup)
                    .withDescription(description)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                    .build();

            logger.debug("  Start Scheduler");
            scheduler.scheduleJob(job, cTrig);


        }catch(Exception ex){
            ex.printStackTrace();
            logger.error(ex.getMessage());
        }

        logger.info("==== createQuartzJob() END ====");
    }

    public void stopJob(String jobName, String jobGroup, String triggerName, String triggerGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroup);
        scheduler.deleteJob(jobKey);
        scheduler.unscheduleJob(triggerKey);
        // scheduler.shutdown();        // just shutdown all trigger, job. but doesn't delete any job or trigger.
    }
}
