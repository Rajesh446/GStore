package com.niit.shoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.DAO.*;
import com.niit.shoppingcart.model.*;

@Controller
public class Suppliercontroller {
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String landPage(@ModelAttribute("supplier")Supplier supplier,BindingResult result,Model model)
	{
		
		model.addAttribute("allSupplier",supplierDAO.list());
		return "Supplier";
		
	}
	 
	@RequestMapping(value="/allSupplier")
	public String getAllData(@ModelAttribute("supplier")Supplier supplier,BindingResult result,Model model)
	{
	
		model.addAttribute("allSupplier",supplierDAO.list());
		return "Supplier";
	}
	
	@RequestMapping(value="/addItem",method = RequestMethod.POST)
	public String addItem(@ModelAttribute("supplier") Supplier s){
		
		this.supplierDAO.saveOrUpdate(s);
		return "redirect:allSupplier";
		
	}
	@RequestMapping(value="/ItemById/{id}",method = RequestMethod.GET)
	public String editItem(@PathVariable("id") int id,RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute("supplier", supplierDAO.get(id));
		return "redirect:/allSupplier";
		
}
	@RequestMapping(value="/deleteById/{id}",method = RequestMethod.GET)
	public String deleteItem(@PathVariable("id") int id,Supplier supplier)
	{
		supplierDAO.delete(supplier);
		return "redirect:/allSupplier";
		
}
}

