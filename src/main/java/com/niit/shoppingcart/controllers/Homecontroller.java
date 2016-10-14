package com.niit.shoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.DAO.*;
import com.niit.shoppingcart.model.Product;




@Controller
public class Homecontroller {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
    
	
@RequestMapping(value={"/HOME"},method=RequestMethod.GET)
public String homepage(Model m){
	m.addAttribute("userclickedhome", "true");
	m.addAttribute("product",new Product());
	m.addAttribute("allCategory", categoryDAO.list());
	m.addAttribute("allProduct",productDAO.list());
	
	return "HOME";
}

@RequestMapping(value ="ShowProduct/{id}" )
public String ShowProduct(@PathVariable("id") int id,RedirectAttributes attributes,Model m) {
m.addAttribute("clickedshowproduct", "true");
	m.addAttribute("IndividualProduct", productDAO.getproduct(id));
	return "IndividualProduct";
}
}
