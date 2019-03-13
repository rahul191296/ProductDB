package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.dao.ProductDAO;
import com.cognizant.entity.Product;
@Service
public class ProductServiceImpl implements ProductService{
   @Autowired@Qualifier("JDBCProductDAOImpl") //there will bebn two class of interface
	private ProductDAO productDAO;
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

}
