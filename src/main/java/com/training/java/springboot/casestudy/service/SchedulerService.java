package com.training.java.springboot.casestudy.service;

import com.training.java.springboot.casestudy.bean.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    Logger logger = LogManager.getLogger(SchedulerService.class);

    @Autowired
    private StudentService studentService;

    public void monitorStudent() {
        try {

            logger.info("======>>  monitorStudent() START");
            logger.info("   . . . Processing");
            List<Student> listStudent = studentService.listStudent();
            logger.info("   . . . List Student Done.");
            if(listStudent != null && listStudent.size() > 0){
                logger.info("    Number of student now : {}", listStudent.size());
                logger.info("    Student List : {}", listStudent);
            }
            logger.info("======>>  monitorStudent() END");

        }catch (Exception ex) {
            logger.error("monitorStudent() Exception ex : " + ex);
        }
    }
}
