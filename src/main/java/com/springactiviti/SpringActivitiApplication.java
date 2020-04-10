package com.springactiviti;

import com.springactiviti.util.LogBack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Version 1.0
 **/
@SpringBootApplication
@ComponentScan({"com.springactiviti","org.activiti"})
public class SpringActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringActivitiApplication.class, args);
        LogBack.info("-----------------------------启动成功------------------------------");
    }
}
