package com.training.java.springboot.casestudy.startup;

import com.training.java.springboot.casestudy.controller.QuartzController;
import com.training.java.springboot.casestudy.helper.quartz.QuartzService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StartupProcess implements InitializingBean, DisposableBean  {

    Logger logger = LogManager.getLogger(StartupProcess.class);

    @Autowired
    private QuartzService quartzService;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("==== START StartupProcess : afterPropertiesSet() ====");

        // Example : when spring boot startup , Quartz job will be created.
        Map<String, String> data = new HashMap<String, String>();
        String jobName = "monitor-students-startup";
        String jobGroup = "MONITOR-STUDENTS";
        String cronExpression = "0 0/2 * * * ?";
        String description = "For monitor student, start at spring boot start.";
        data.put("jobName", jobName);
        data.put("jobGroup", jobGroup);
        data.put("cronExpression", cronExpression);
        data.put("description", description);
        quartzService.scheduleJobByCron(data);

        logger.debug("  Create startup job successfully.");

        logger.info("==== END StartupProcess : afterPropertiesSet() ====");
    }



    @Override
    public void destroy() throws Exception {

        logger.info("==== START StartupProcess : destroy() ====");

        String jobName = "monitor-students-startup";
        String jobGroup = "MONITOR-STUDENTS";
        quartzService.stopJob(jobName, jobGroup, jobName, jobGroup);
        logger.debug("  Stop job successfully.");

        logger.info("==== END StartupProcess : destroy() ====");

    }


}
