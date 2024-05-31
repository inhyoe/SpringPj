package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

   @RequestMapping("say-hello")
   //여기까지만 하면 뷰라는걸 스프링이 인지하지 못함
   @ResponseBody
   public String sayHello(){
      return "Hello What do u want?";
   }

   @RequestMapping("say-html")
   //여기까지만 하면 뷰라는걸 스프링이 인지하지 못함
   @ResponseBody
   public String sayHtml(){
      StringBuffer sb = new StringBuffer();
      sb.append("<html>");
      sb.append("<head>");
      sb.append("<title>My first HTML Page</title>");
      sb.append("<body>Ang Gimozzi</body>");
      sb.append("</head>");
      sb.append("</html>");

      return sb.toString();
   }

   //src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
   @RequestMapping("say-jsp")
   //여기까지만 하면 뷰라는걸 스프링이 인지하지 못함
   public String sayHelloJsp(){
      return "sayHello";
   }

   @RequestMapping("say-fuck")
   //여기까지만 하면 뷰라는걸 스프링이 인지하지 못함
   public String sayFuckJsp(){
      return "fuckYou";
   }
}
