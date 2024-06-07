package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
public class TodoController {

   public TodoController(TodoService todoService) {
      this.todoService = todoService;
   }

   private TodoService todoService;

   @RequestMapping("list-todos")
   public String listAllTodos(ModelMap model){
      List<Todo> todos = todoService.findByUsername("Ryu");

      model.put("todos" , todos.toString());

      return "listTodos";
   }
}
