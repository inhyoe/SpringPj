package com.in28minutes.rest.website.restful_web_services.helloworld;

//REST API

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {
   // api - hello world

//   @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
   @GetMapping(path = "/hello-world")
   public String helloWorld() {
      return "hello world";
   }

   @GetMapping(path = "/hello-world-bean")
   public HelloWorldBean helloWorldBean() {
      return new HelloWorldBean("Hello World");
   }
}
