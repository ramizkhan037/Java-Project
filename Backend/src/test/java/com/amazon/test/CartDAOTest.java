package com.amazon.test;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.dao.CartDAO;
import com.amazon.model.Cart;

public class CartDAOTest 
{
     static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.amazon");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
    @Ignore
	@Test
	public void addCartTest()
	{
		Cart cart=new Cart();
		cart.setProductId(52);
		cart.setProductName("Wireless Mouse");
		cart.setQuantity(3);
		cart.setUsername("Ramiz");
		cart.setPrice(1500);
		cart.setStatus("N");
		
		assertTrue("Problem in Adding to the Cart",cartDAO.addToCart(cart));
    }
    @Ignore
    @Test
    public void updateCartTest()
    {
    	Cart cart=cartDAO.getCartItem(55);
		cart.setQuantity(5);
		
		assertTrue("Problem in Updating to the Cart",cartDAO.updateCartItem(cart));
    }
    @Ignore
    @Test
    public void listCartItemsTest()
    {
    	List<Cart> listCartItems=cartDAO.listCartItems("Ramiz");
    	
    	assertTrue("Problem in Displaying to the CartItems",listCartItems.size()>0);
    	
    	for(Cart cart:listCartItems)
    	{
    	 System.out.println("Cart ID:"+cart.getCartId()); 
    	 System.out.println("Cart Price:"+cart.getPrice()); 
    	 System.out.println("Cart ProductName:"+cart.getProductName()); 

    	}
            	
    }
}
