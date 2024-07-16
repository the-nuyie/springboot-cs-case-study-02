package com.training.java.springboot.casestudy.controller;

import com.training.java.springboot.casestudy.bean.Student;
import com.training.java.springboot.casestudy.config.MailConfig;
import com.training.java.springboot.casestudy.service.Log4jProgrammaticallyService;
import com.training.java.springboot.casestudy.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/controller/rest-simple")
public class RestSimpleController {

    Logger logger = LogManager.getLogger(RestSimpleController.class);
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private MailConfig mailConfig;

    @Autowired
    private Log4jProgrammaticallyService logj4ProgrammaticallyService;

    @GetMapping("/list-students")
    public Map<String, Object> listStudents() {

        // logger.debug("Data : "+data);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");


        logger.debug("Start Call BusinessLogic()");
        try{
            logger.debug("List all student");
            List<Student> listStudent = studentService.listStudent();
            logger.debug("listStudent = "+listStudent);
            hashMapReturn.put("RESULT", listStudent);
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End Call BusinessLogic()");

        return hashMapReturn;
    }

    @PostMapping("/add-student")
    public Map<String, Object> addStudent(@RequestBody Student student) {

        logger.debug("Data : "+student);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");


        logger.debug("Start Call BusinessLogic()");
        try{
            logger.debug("Add new student");
            studentService.addNewStudent(student);
            logger.debug("Add new student successfully.");
            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End Call BusinessLogic()");

        return hashMapReturn;
    }














    // TEST CUSTOM CONFIG ===========================================================

    @GetMapping("/read-mail-config")
    public Map<String, Object> readMailConfig() {
        logger.debug("Start Call readMailConfig()");
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");



        try{
            logger.debug("Read mail config : ");
            logger.debug("  {}",mailConfig.toString());

            hashMapReturn.put("RESULT", mailConfig.toString());
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End Call readMailConfig()");

        return hashMapReturn;
    }







    // TEST NO SPRING ===========================================================
    @PostMapping("/add-student-no-spring")
    public Map<String, Object> addStudentNoSpring(@RequestBody Student student) {

        logger.debug("Data : "+student);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");


        logger.debug("Start Call BusinessLogic()");
        try{
            logger.debug("Add new student");
            studentService.addNewStudentNoSpring(student);
            logger.debug("Add new student successfully.");
            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End Call BusinessLogic()");

        return hashMapReturn;
    }

    @PostMapping("/add-student-no-spring-not-pass-connection")
    public Map<String, Object> addStudentNoSpringNotPassConnection(@RequestBody Student student) {

        logger.debug("Data : "+student);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");


        logger.debug("Start Call BusinessLogic()");
        try{
            logger.debug("Add new student");
            studentService.addNewStudentNoSpringNotPassConnection(student);
            logger.debug("Add new student successfully.");
            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End Call BusinessLogic()");

        return hashMapReturn;
    }

    @PostMapping("/write-log4j-program")
    public Map<String, Object> writeLogj4Program() {

        logger.debug("Start Call writeLogj4Program()");

        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");



        try{
            logger.debug("Write simple log");
            logj4ProgrammaticallyService.writeSampleLog();

            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End Call writeLogj4Program()");

        return hashMapReturn;
    }
}
