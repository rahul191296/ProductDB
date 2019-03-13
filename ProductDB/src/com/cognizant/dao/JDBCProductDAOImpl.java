package com.cognizant.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Product;
import com.cognizant.helper.ConnectionManager;
import com.cognizant.helper.ProductQuery;

@Repository("JDBCProductDAOImpl")
public class JDBCProductDAOImpl implements ProductDAO {
	@Autowired
	private ConnectionManager manager;

	@Autowired
	private ProductQuery productquery;

	public List<Product> getAllProducts() {
		Connection connection = manager.openConnection();
		List<Product> productList = new ArrayList<Product>();
		try {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(productquery.getSelectAllProductQuery());
			while (resultSet.next()) {
				Product product = new Product();
				product.setProductId(resultSet.getInt("product_id"));
				product.setProductName(resultSet.getString("product_name"));
				product.setProductCategory(resultSet.getString("product_category"));
				product.setProductdescription(resultSet.getString("product_description"));
				product.setProductPrice(resultSet.getDouble("product_price"));
				product.setBrand(resultSet.getString("brand"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		manager.closeConnection();
		return productList;
	}
}
