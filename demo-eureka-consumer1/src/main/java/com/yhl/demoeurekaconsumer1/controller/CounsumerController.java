package com.yhl.demoeurekaconsumer1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@RestController
public class CounsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;


    @RequestMapping(value = "/userall")
    public String testgetUser(){
        return restTemplate.getForObject("http://eureka-provider1/user/userall",String.class);

    }
    @RequestMapping(value = "/details/{userid}")
    public String testgetUserById(@PathVariable(value = "userid") String id) {
        System.out.println(id);
        return restTemplate.getForObject("http://eureka-provider1/user/details?userid="+id, String.class);
    }

    @RequestMapping(value = "/adduser")
    @ResponseBody
    public ResponseEntity<String> testaddUser(@RequestBody User user) {
        return restTemplate.postForEntity("http://eureka-provider1/user/add",user,String.class);
    }

    @RequestMapping("/port")
    public String testport(){
        return restTemplate.getForObject("http://eureka-provider1/port",String.class);

    }

//    @GetMapping( " /sayHi")
//    @HystrixCommand(fallbackMethod = "sayHiFallback" , commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="30000")
//    })
//    public String hello(@RequestParam(value = "sleep_seconds") int sleep_seconds) throws InterruptedException {
//        ServiceInstance serviceInstance = loadBalancerClient.choose(  "eureka-provider1");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()+
//        "/user/sayHi?sleep_seconds="+sleep_seconds;
//        System.out.println(url );
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, String.class) ;
//    }
//    public String sayHiFallback(int sleep_seconds) { return "??????User??????????????????????????????.??????"; }

    @GetMapping("/sayHi")
    @HystrixCommand( fallbackMethod = "sayHiFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" , value="30000")
})
    public String hello(@RequestParam(value = "sleep_seconds") int sleep_seconds) throws InterruptedException {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider1");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() +
                "/user/sayHi?sleep_seconds=" + sleep_seconds;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
public String sayHiFallback(int sleep_seconds) { return "??????User??????????????????????????????.??????";}









        }
