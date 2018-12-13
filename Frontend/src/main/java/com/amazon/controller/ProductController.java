package com.amazon.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazon.dao.CategoryDAO;
import com.amazon.dao.ProductDAO;
import com.amazon.model.Category;
import com.amazon.model.Product;

@Controller
public class ProductController 
{
	
    @Autowired
    ProductDAO productDAO;
       
    @Autowired
    CategoryDAO categoryDAO;
    
    @RequestMapping(value="/product")
    public String showProduct(Model m)
    {
    	List<Product> listProducts=productDAO.listProducts();
    	m.addAttribute("productlist",listProducts);
    	
    	Product product=new Product();
    	m.addAttribute("product",product);
    	
    	m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
    	
    	return "Product";
    }
    
    @RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
    public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage") MultipartFile prodImage,Model m)
    {
    	productDAO.addProduct(product);

    	String path="F:\\NIITProject\\Frontend\\src\\main\\webapp\\resources\\images\\";
    	
    	path=path+String.valueOf(product.getProductId())+".jpg";
    	
    	File imageFile=new File(path);
    	
    	if(!prodImage.isEmpty())
    	{
    		try
    		{
    			byte[] buffer=prodImage.getBytes();
    			FileOutputStream fos=new FileOutputStream(imageFile);
    			BufferedOutputStream bs=new BufferedOutputStream(fos);
    			bs.write(buffer);
    			bs.close();
    		}
    		catch(Exception e)
    		{
        		m.addAttribute("Error","Exception Occured during the Image Uploading"+e);
    		}
    	}
    	else
    	{
    		m.addAttribute("Error","Error Occured during the Image Uploading");
    	}
    	
    	Product product1=new Product();
    	m.addAttribute("product", product1);
    	
    	List<Product> listProducts=productDAO.listProducts();
    	m.addAttribute("productlist", listProducts);

    	m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));
	
    	return "Product";
   
    }
    @RequestMapping(value="/editProduct/{productID}")
    public String editProduct(@PathVariable("productID") int productID,Model m)
    {
    	System.out.println("In edit product");
    	Product product=productDAO.getProduct(productID);
    	productDAO.updateProduct(product);
    	
    	m.addAttribute("product",product);
    	
    	List<Product> listProducts=productDAO.listProducts();
    	m.addAttribute("productlist", listProducts);

    	m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));

    	
    	return "Product";
    }
    @RequestMapping(value="/deleteProduct/{productID}")
    public String deleteProduct(@PathVariable("productID")int productID,Model m)
    {
    	Product product=productDAO.getProduct(productID);
    	productDAO.deleteProduct(product);

    	Product product1=new Product();
    	m.addAttribute("product", product1);
    	
    	List<Product> listProducts=productDAO.listProducts();
    	m.addAttribute("productlist", listProducts);

    	m.addAttribute("categoryList",this.getCategoryList(categoryDAO.listCategories()));

    	return "Product";
    	
    }
    public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory)
    {
    	LinkedHashMap<Integer,String> listCategories=new LinkedHashMap<Integer,String>();

    	for(Category category:listCategory)
    	  {
    		  listCategories.put(category.getCategoryId(),category.getCategoryName());
    	  }
    	  
    	  return listCategories;
    	  
    }
   
    @RequestMapping(value="/productDisplay")
    public String productDisplay(Model m)
    {
    	List<Product> listProducts=productDAO.listProducts();
    	m.addAttribute("productlist",listProducts);
    
    	return "ProductDisplay";
    }
    
    @RequestMapping(value="/totalProductDisplay/{productID}")
    public String productDisplay(@PathVariable("productID")int productID,Model m)
    {
       Product product=productDAO.getProduct(productID);
    	
    	m.addAttribute("product",product);
    	
    	return "TotalProductDisplay";
    }
    
}
