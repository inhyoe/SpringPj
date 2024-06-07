package com.in28minutes.rest.website.restful_web_services.hellowrold;

public class HelloWorldBean {
   private String message;

   public HelloWorldBean(String message) {
      this.message=message;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }


   //json Message가 반호나됨
   @Override
   public String toString() {
      return "HelloWorldBean{" +
              "message='" + message + '\'' +
              '}';
   }
}
