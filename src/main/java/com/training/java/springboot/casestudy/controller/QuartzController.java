package com.training.java.springboot.casestudy.controller;

import com.training.java.springboot.casestudy.bean.Student;
import com.training.java.springboot.casestudy.helper.quartz.QuartzService;
import com.training.java.springboot.casestudy.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/controller/quartz")
public class QuartzController {

    Logger logger = LogManager.getLogger(QuartzController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private QuartzService quartzService;

    @GetMapping("/list-jobs")
    public Map<String, Object> listJobs() {

        logger.debug("Start Call listJobs()");

        // logger.debug("Data : "+data);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");



        try{
            logger.debug("List all quartz job");

            List<Map<String, String>> listJob = quartzService.listJob();

            logger.debug("listJob = "+listJob);

            hashMapReturn.put("RESULT", listJob);
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End Call listJobs()");

        return hashMapReturn;
    }

    @PostMapping("/create-job")
    public Map<String, Object> createJob(@RequestBody Map<String, String> data) {

        logger.info("Start createJob()");

        logger.debug("Data : "+data);
        // String jobName = data.get("jobName");

        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");

        try{
            logger.debug("Start Scheduler Job");
            quartzService.scheduleJobByCron(data);
            logger.debug("Start Scheduler Job successfully.");
            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.info("END createJob()");

        return hashMapReturn;
    }

    @PostMapping("/stop-job")
    public Map<String, Object> stopJob(@RequestBody Map<String, String> data) {

        logger.info("Start stopJob()");

        logger.debug("Data : "+data);
        // String jobName = data.get("jobName");

        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");

        try{
            String jobName = data.get("jobName");
            String jobGroup = data.get("jobGroup");
            logger.debug("Start Stop Job");
            quartzService.stopJob(jobName, jobGroup, jobName, jobGroup);
            logger.debug("Stop Scheduler Job successfully.");
            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.info("END stopJob()");

        return hashMapReturn;
    }
}
