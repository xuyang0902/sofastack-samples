package com.ant.sofastack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author xu.qiang
 * @date 20/2/15
 */
@SpringBootApplication
//@ImportResource(locations = "classpath:/consumer.xml")
public class SofaPortalBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(SofaPortalBootStrap.class, args);


        System.out.println("--->sofa portal started");
    }
}
