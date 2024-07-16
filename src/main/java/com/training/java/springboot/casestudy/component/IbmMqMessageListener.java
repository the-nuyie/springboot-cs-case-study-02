package com.training.java.springboot.casestudy.component;

import com.training.java.springboot.casestudy.bean.Student;
import com.training.java.springboot.casestudy.controller.IBMMQController;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class IbmMqMessageListener {

    Logger logger = LogManager.getLogger(IbmMqMessageListener.class);

    @JmsListener(destination = "${ibm.mq.in.q1}")
    public void onMessageReceived(final Message message) throws JMSException {
        if (message instanceof TextMessage) {
            String text = ((TextMessage) message).getText();
            logger.debug("  Received message !! Text Message = "+text);
        }else if(message instanceof Student) {
            Student stu = (Student) message;
            logger.debug("  Received message !! Object Message = "+stu);
        }
    }
}
