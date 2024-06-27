package com.training.java.springboot.casestudy.service;

import com.training.java.springboot.casestudy.bean.Student;
import com.training.java.springboot.casestudy.repository.StudentRepository;
import com.training.java.springboot.dependencyjar.cs.gateway.util.LogUtil;
import com.training.java.springboot.dependencyjar.cs.gateway.util.common.Const;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Log4jProgrammaticallyService {

    org.apache.logging.log4j.Logger loggerSp = LogManager.getLogger(Log4jProgrammaticallyService.class);

    public Logger logger = null;
    public LogUtil logUtil = null;

    @Autowired
    private StudentRepository studentRepository;

    public void writeSampleLog() {

        try{
            String logName = getClass().getName();
            loggerSp.debug("  logName = {}", logName);

            logUtil = new LogUtil(Const.SCHEDULE_FOLDER_NAME,Const.SCHEDULE_FOLDER_NAME, logName);
            logger = logUtil.getLogger();
            logger.info("### writeSampleLog - info ");
            logger.debug("### writeSampleLog - debug ");

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            logUtil.closeLogger(logger);
        }


    }



}
