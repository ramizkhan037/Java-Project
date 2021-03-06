package com.amazon.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.dao.CategoryDAO;
import com.amazon.model.Category;

public class CategoryDAOTest 
{

	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.amazon");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("ComputerParts");
		category.setCategoryDesc("hardware related Parts");
		
		assertTrue("Probem in Adding the Category",categoryDAO.add(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{	
		Category category=categoryDAO.getCategory(2);
		category.setCategoryDesc("both hardware and software");	
		assertTrue("Problem in Updating the Category",categoryDAO.update(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		assertTrue("Problem in Updating the Category",categoryDAO.delete(category));
	}
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing the Categories",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print("Category ID:"+category.getCategoryId());
			System.out.print("Category Name:"+category.getCategoryName());
			System.out.println("Category Desc:"+category.getCategoryDesc());
		}
	}
}


