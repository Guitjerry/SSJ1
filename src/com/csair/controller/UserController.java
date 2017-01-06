package com.csair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csair.entity.User;
import com.csair.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
   @Autowired
   private UserService userSerivce;
   @RequestMapping(value="/welcome")
   public ModelAndView getUser(ModelAndView modelView)
   {
	   User user = userSerivce.getUser(1);
	    return new ModelAndView("welcome","user",user);
   }
}
