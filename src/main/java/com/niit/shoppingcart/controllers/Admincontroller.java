package com.niit.shoppingcart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admincontroller {
	
	 @RequestMapping(value = "/")
	    public String init(Model model) {
	        model.addAttribute("msg", "ADMIN");
	        return "Admin";
	

	 }
	
}
