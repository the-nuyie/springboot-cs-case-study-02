package com.training.java.springboot.casestudy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail.config")
public class MailConfig {

    private String mainSubject;
    private String mainTo;
    private String mainContent;

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    public String getMainTo() {
        return mainTo;
    }

    public void setMainTo(String mainTo) {
        this.mainTo = mainTo;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MailConfig{");
        sb.append("mainSubject='").append(mainSubject).append('\'');
        sb.append(", mainTo='").append(mainTo).append('\'');
        sb.append(", mainContent='").append(mainContent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
