package com.amazon.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.dao.SupplierDAO;
import com.amazon.model.Category;
import com.amazon.model.Supplier;


public class SupplierDAOTest 
{

	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.amazon");
		context.refresh();
		
	    supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	@Ignore
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("rohit");
		supplier.setSupplierAddr("nagpur");
		
		assertTrue("Probem in Adding the Category",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplier()
	{
		Supplier supplier=supplierDAO.getSupplier(6);
		supplier.setSupplierAddr("Hyderbad");
		supplier.setSupplierName("rohit");
		
		assertTrue("Problem in Updating the Supplier",supplierDAO.updateSupplier(supplier));
	}
    @Ignore	
	@Test
	public void deleteSupplier()
	{
		Supplier supplier=supplierDAO.getSupplier(50);
		supplier.setSupplierAddr("Hyderbad");
		supplier.setSupplierName("rohit");
		
		assertTrue("Problem in Updating the Supplier",supplierDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void listSuppliers()
	{
       List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		
		assertTrue("Problem in Listing the Categories",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print("Supplier ID:"+supplier.getSupplierId());
			System.out.print("Supplier Name:"+supplier.getSupplierAddr());
			System.out.println("Supplier Desc:"+supplier.getSupplierName());
		}
	}
	
}
