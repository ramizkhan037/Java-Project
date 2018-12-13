package com.amazon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amazon.dao.CartDAO;
import com.amazon.dao.ProductDAO;
import com.amazon.model.Cart;
import com.amazon.model.Product;


@Controller
public class CartController 
{
    @Autowired
    CartDAO cartDAO;
    
    @Autowired
    ProductDAO productDAO;
    
    @RequestMapping(value="/addToCart/{productId}")
    public String addToCart(@PathVariable("productId")int productId,@RequestParam("")int quantity,Model m,HttpSession session)
    {
    	Cart cart=new Cart();
    	
    	String username="Ramiz";
    	
        Product product=productDAO.getProduct(productId);
    	cart.setProductId(productId);
    	cart.setPrice(product.getPrice());
    	cart.setProductName(product.getProductName());
    	cart.setQuantity(quantity);
    	cart.setStatus("N");
    	cart.setUsername("Ramiz");
    	
    	cartDAO.addToCart(cart);
    	
    	List<Cart> listCartItems=cartDAO.listCartItems(username);
    			
    	m.addAttribute("cartItems",listCartItems);
    	m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItems));
    	
    	return "Cart";
    }
    public int calcGrandTotalPrice(List<Cart> listCartItems)
    {
    	 int grandTotal=0;
    	 
    	 int count=0;
    	  
    	 while(count<listCartItems.size())
    	 {
    		 Cart cart=listCartItems.get(count);
    		 grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
    		 count++;
    		 
    	 }
      return grandTotal;
    }
    
    @RequestMapping(value="/updateCartItem/{cartId}")
    public String updateCartItem(@PathVariable("cartId")int cartId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
    {
    	String username="Ramiz";
    	Cart cart=cartDAO.getCartItem(cartId);
    	cart.setQuantity(quantity);
    	cartDAO.updateCartItem(cart);

    	List<Cart> listCartItems=cartDAO.listCartItems(username);
		
    	m.addAttribute("cartItems",listCartItems);
    	m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItems));

    	return "cart";
    }
    @RequestMapping(value="/deleteCartItem/{cartId}")
    public String deleteCartItem(@PathVariable("cartId")int cartId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
    {
    	String username="Ramiz";
    	Cart cart=cartDAO.getCartItem(cartId);
    	cartDAO.deleteItemFromCart(cart);

        List<Cart> listCartItems=cartDAO.listCartItems(username);
		
    	m.addAttribute("cartItems",listCartItems);
    	m.addAttribute("grandTotal", this.calcGrandTotalPrice(listCartItems));

    	
    	return "Cart";
    }


}
