package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

   // http://localhost:8080/login?name=Ryu <= RequestParam
   @RequestMapping("login")
   public String gotoLoginPage(@RequestParam("name")String name, ModelMap model){
      model.put("name", name);
      System.out.println(name);
      return "login";
   }
}
