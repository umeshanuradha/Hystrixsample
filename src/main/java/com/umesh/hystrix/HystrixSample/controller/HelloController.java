package com.umesh.hystrix.HystrixSample.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umesh on 11/25/18.
 */

@RestController
@RequestMapping(value = "/rest")
public class HelloController {


    @HystrixCommand(fallbackMethod = "fallBackSayHello", commandKey = "hello" , groupKey = "hello")
    @GetMapping(value = "/hello")
    public String sayHello(){


        // so if the hystrix implementation is not there it will throw the exception to the front end
        if(RandomUtils.nextBoolean()){
            throw new RuntimeException("Failed");
        }

        return "Hello workd";
    }


    public String fallBackSayHello(){

        return "fallback hello world";
    }


    // added another method with the same fallBackHello  method
    // so in the hystrix dashboard we can see both
    @HystrixCommand(fallbackMethod = "fallBackSayHello", commandKey = "hello2" , groupKey = "hello2")
    @GetMapping(value = "/hello2")
    public String sayHello2(){

        // so if the hystrix implementation is not there it will throw the exception to the front end
        if(RandomUtils.nextBoolean()){
            throw new RuntimeException("Failed");
        }

        return "Hello workd";
    }



}
