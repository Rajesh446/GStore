package com.niit.shoppingcart.controllers;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.DAO.CategoryDAO;
import com.niit.shoppingcart.DAO.ProductDAO;
import com.niit.shoppingcart.DAO.UserDAO;
import com.niit.shoppingcart.model.User;



@Controller
public class Registercontroller {
	

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	/*@Autowired
	CartDAO cartDAO;*/
	
	@RequestMapping(value = {"/LOGIN"})
	public String DisplayLogin(Model mv) {
		mv.addAttribute("user", new User());
		mv.addAttribute("userclickedlogin", "true");
		mv.addAttribute("HideOthers","true");
		return "LOGIN";
	}
	
	@RequestMapping(value = "Registration")
	public String DisplayRegister(Model mv) {
		mv.addAttribute("user", new User());
		/*mv.addAttribute("categoryList", categoryDAO.list());
		mv.addAttribute("productList", productDAO.list());*/
		mv.addAttribute("userclickeduser", "true");
		mv.addAttribute("HideOthers","true");
		return "HOME";
	}
	
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String UserRegister(@ModelAttribute("user") User user, ModelAndView mv) {
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		userDAO.saveOrUpdate(user);
		mv.addObject("message", "Registration Success");
		return "redirect:/";
	}
	

	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDAO.get(username);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("name", user.getUsername());
		session.setAttribute("LoggedIn", "true");

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for (GrantedAuthority authority : authorities) 
		{
		  
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
		    	 return "redirect:/";
		     
		     }
		     else 
		     {
		    	 session.setAttribute("Administrator", "true");
			return "/Admin";
		     }
		}
		return "Home";

}*/
}