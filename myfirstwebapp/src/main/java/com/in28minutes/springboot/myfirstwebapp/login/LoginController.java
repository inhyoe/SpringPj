package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


   private Logger logger = LoggerFactory.getLogger(LoginController.class);
   private Logger logger2 = LoggerFactory.getLogger(getClass());
   // http://localhost:8080/login?name=Ryu <= 쿼리 파라미터 ( RequestParam )
   @RequestMapping(value = "login", method = RequestMethod.GET)
   public String gotoLoginPage(){
      return "login";
   }

   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

      model.put("name", name);
      model.put("password", password);

      return "sayHello";

   }
}
