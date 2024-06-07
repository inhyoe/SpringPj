package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

   // -> 스프링을 사용하지 않을 경우 이렇게 사용해야함
   // private final AuthenticationService authenticationService = new AuthenticationService();

   // 스프링을 사용할 경우
   public LoginController(AuthenticationService authenticationService) {
      this.authenticationService = authenticationService;
   }

   private final AuthenticationService authenticationService;

   // http://localhost:8080/login?name=Ryu <= 쿼리 파라미터 ( RequestParam )
   @RequestMapping(value = "login", method = RequestMethod.GET)
   public String gotoLoginPage(){
      return "login";
   }

   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

      if (authenticationService.isAuthenticated(name, password)) {

         model.put("name", name);
         model.put("password", password);
         return "sayHello";
      }

      model.put("error" , "Invalid Xredentails");
      return "login";
   }
}
