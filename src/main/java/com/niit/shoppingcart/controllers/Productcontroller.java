package com.niit.shoppingcart.controllers;

import java.io.File;
import java.io.IOException;
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
	public String addProduct(@ModelAttribute("product") Product product , Model model,HttpServletRequest request, MultipartFile file) throws IOException
	{
		
		
	            productDAO.saveOrUpdate(product);
	    		System.out.println("Data Inserted");
	            //String path = request.getSession().getServletContext().getRealPath("/resources/images/" + user.getUserid() + ".jpg");
	    		MultipartFile image = product.getImage();
	            //Path path;
	            String path = request.getSession().getServletContext().getRealPath("/resources/images/Product/"+product.getId()+".jpg");
	            System.out.println("Path="+path);
	            System.out.println("File name = " + product.getImage().getOriginalFilename());
	          
	            if(image!=null && !image.isEmpty())
	            {
	            	try
	            	{
	            		image.transferTo(new File(path.toString()));
	            		System.out.println("Image saved  in:"+path.toString());
	            	}
	            	catch(Exception e)
	            	{
	            		e.printStackTrace();
	            		System.out.println("Image not saved");
	            	}
	            }
	    	
	     	    
	    return "Product";
	
		
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