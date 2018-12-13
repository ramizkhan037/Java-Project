package com.amazon.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.amazon.dao.ProductDAO;
import com.amazon.model.Product;

public class ProductDAOTest 
{
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.amazon");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Hard Disc");
		product.setProductDesc("1 TeraByte");
		product.setPrice(7500);
		product.setStock(10);
		product.setSupplierId(1);
		product.setCategoryId(1);
		
		assertTrue("Probem in Adding the Category",productDAO.addProduct(product));
	}
	 @Ignore
	 @Test
	 public void updateProductTest()
	 {	
			Product product=productDAO.getProduct(5);
			product.setProductName("Hard Disc");
			product.setProductDesc("2 TeraByte");
			product.setPrice(7500);
			product.setStock(10);
			product.setSupplierId(1);
			product.setCategoryId(1);
			
			assertTrue("Probem in updating the Category",productDAO.updateProduct(product));
	 }
	 @Ignore
	 @Test
	 public void deleteProductTest()
	 {	
			Product product=productDAO.getProduct(48);
			product.setProductName("HeadPhone");
			product.setProductDesc("Samsung");
			product.setPrice(500);
			product.setStock(20);
			product.setSupplierId(1);
			product.setCategoryId(36);
			
			assertTrue("Probem in deleting the Category",productDAO.deleteProduct(product));
      }
	 @Ignore
	 @Test
	 public void listProductsTest()
	 {
		List<Product> listProducts=productDAO.listProducts();
			
		assertTrue("Problem in Listing the Products",listProducts.size()>0);
			
			for(Product product:listProducts)
			{
				System.out.print("Product ID:"+product.getProductId());
				System.out.print("Product Name:"+product.getProductName());
				System.out.print("Product Desc:"+product.getProductDesc());
				System.out.print("Product Price:"+product.getPrice());
				System.out.print("Product Stock:"+product.getStock());
				System.out.print("Product SupplierId:"+product.getSupplierId());
				System.out.print("Product CategoryId:"+product.getCategoryId());
			}
	}
}	 


