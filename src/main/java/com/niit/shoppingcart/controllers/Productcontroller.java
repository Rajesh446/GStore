package com.niit.shoppingcart.controllers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.DAO.CategoryDAO;
import com.niit.shoppingcart.DAO.ProductDAO;
import com.niit.shoppingcart.DAO.SupplierDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class Productcontroller {


		@Autowired
	 ProductDAO productDAO;
		@Autowired
	 CategoryDAO categoryDAO;
		@Autowired
	 SupplierDAO supplierDAO;
		private Path path;
		
		@RequestMapping(value="/Product",method = RequestMethod.GET)
		public ModelAndView landPage(@ModelAttribute("product")Product product,BindingResult result,Model model)
		{
			ModelAndView mv=new ModelAndView("/Product");
			mv.addObject("userclickedproduct", "true");
			mv.addObject("allProduct",productDAO.list());
			mv.addObject("allCategory",categoryDAO.list());
			mv.addObject("allSupplier",supplierDAO.list());
			return mv;
			
		}
		 
		/*@RequestMapping(value="/allData")
		public String getAllData(@ModelAttribute("product")Product product,BindingResult result,Model model)
		{
		
			model.addAttribute("allData",productDAO.list());
			return "Product";
		}*/
	@RequestMapping(value="/addProduct")
	public String addItem(@ModelAttribute("product") Product p){
			
			productDAO.saveOrUpdate(p);
		
	    	/*MultipartFile file=p.getImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "\\resources\\images\\"+p.getId()+".jpg");
	        if (file != null && !file.isEmpty()) {
	            try {
	            	System.out.println("Image Saving Start");
	            	file.transferTo(new File(path.toString()));
	            	System.out.println("Image Saved");
	            } catch (Exception e) {
	                e.printStackTrace();
	                System.out.println("Error");
	                throw new RuntimeException("item image saving failed.", e);
	            }
	        }*/
			return "redirect:/Product";
			
		}
		@RequestMapping(value="/ProductEditById/{id}")
		public String editItem(@PathVariable("id") int id,RedirectAttributes redirectAttributes)
		{
			redirectAttributes.addFlashAttribute("product", productDAO.get(id));
			return "redirect:/Product";
			
	}
		@RequestMapping(value="/ProductDeleteById/{id}")
		public String deleteItem(@PathVariable("id") int id,Product product)
		{
			productDAO.delete(product);
			return "redirect:/Product";
			
	}
	}