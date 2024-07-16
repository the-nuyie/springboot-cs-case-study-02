package com.training.java.springboot.casestudy.controller;


import com.training.java.springboot.casestudy.bean.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/controller/ibmmq")
public class IBMMQController {

    Logger logger = LogManager.getLogger(IBMMQController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${ibm.mq.in.q1}")
    private String queueNameInput;

    @PostMapping("/send-plain")
    public Map<String, Object> sendPlain(@RequestBody String plainMessage) {

        logger.debug("Data : "+plainMessage);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");


        logger.debug("Start sendPlain");
        try{

            // jmsTemplate.convertAndSend("DEV.QUEUE.1", plainMessage);
            jmsTemplate.convertAndSend(queueNameInput, plainMessage);

            logger.debug("  Message sent.");
            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End sendPlain");

        return hashMapReturn;
    }

    @GetMapping("/receive-plain")
    public Map<String, Object> receivePlain() {

        // logger.debug("Data : "+data);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");


        logger.debug("Start receivePlain()");
        try{

            String plainText = jmsTemplate.receiveAndConvert("DEV.QUEUE.1").toString(); // This line will wait until message is available in MQ.
            logger.debug("  Message received : "+plainText);

            hashMapReturn.put("RESULT", plainText);
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End receivePlain()");

        return hashMapReturn;
    }


    @PostMapping("/send-object")
    public Map<String, Object> sendObject(@RequestBody Student student) {

        logger.debug("Data : "+student);
        // String jobName = data.get("jobName");
        Map<String, Object> hashMapReturn = new HashMap<String, Object>();
        hashMapReturn.put("CODE", "0000");
        hashMapReturn.put("TECH_MESSAGE", null);
        hashMapReturn.put("MESSAGE", "SUCCESS");


        logger.debug("Start sendObject");
        try{

            jmsTemplate.convertAndSend("DEV.QUEUE.1", student);

            logger.debug("  Message sent.");
            hashMapReturn.put("RESULT", "DONE");
        }catch(Exception ex){
            ex.printStackTrace();
            hashMapReturn.put("CODE", "9999");
            hashMapReturn.put("TECH_MESSAGE", ex.getMessage());
            hashMapReturn.put("MESSAGE", "FAILED");
        }
        logger.debug("End sendObject");

        return hashMapReturn;
    }

}
