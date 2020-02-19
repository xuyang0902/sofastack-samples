package com.ant.sofastack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xu.qiang
 * @date 20/2/15
 */
@SpringBootApplication
public class SofaTradeBootStrap {

    public static void main(String[] args) {


        ConfigurableApplicationContext applicationContext = SpringApplication.run(SofaTradeBootStrap.class, args);

        System.out.println("--->>>> sofa-trade 已经启动 打印容器的beanName");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
}
