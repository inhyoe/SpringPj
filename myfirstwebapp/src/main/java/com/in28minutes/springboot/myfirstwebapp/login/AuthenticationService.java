package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

//이 부분도 중요함
@Service
public class AuthenticationService {

   public boolean isAuthenticated(String username, String password){

      boolean isValidUserName = username.equalsIgnoreCase("ryu");

      boolean isValidPassword = password.equalsIgnoreCase("password");

      return isValidUserName && isValidPassword ;
   }
}
