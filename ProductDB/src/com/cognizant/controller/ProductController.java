package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Product;
import com.cognizant.service.ProductService;



@Controller
public class ProductController {
	@Autowired
private ProductService productService;
	@RequestMapping(value="viewProducts.htm",method=RequestMethod.GET)
	public ModelAndView viewProducts(){
		List<Product> productList=productService.getAllProducts();
		ModelAndView mv=new ModelAndView();
		mv.addObject("productList",productList);
		mv.setViewName("viewproducts");
		return mv;
	}
}
