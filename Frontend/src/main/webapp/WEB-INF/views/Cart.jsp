<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Cart</h3>

<table class="table bordered">

<tr>
    <td>SL #</td>
    <td>Product Name</td>
    <td>Quantity</td>
    <td>Price</td>
    <td>Total Price</td>
    <td>Operation</td>
</tr>

<c:forEach items="${cartItems}" var="cart">
<form action="<c:url value="/updateCartItem/${cart.cartId}"/>" method="get">
<tr>
    <td></td>
    <td>${cart.productName}</td>
    <td> <input type="text" name="quantity" value="${cart.quantity}"/></td>
    <td>${cart.price}</td>
    <td>${cart.quantity * cart.price}/-</td>
    <td>
        <input type="submit" value="update" class="btn btn-success"/>
        <a class="btn btn-danger" href="<c:url value="/deleteCartItem/${cart.cartId}"/>" method="get">DELETE</a>
     </td>
 </tr>   
</form>
</c:forEach> 
<tr bgcolor="cyan">
   <td colspan="4">Grand Total</td>
   <td colspan="2">Rs.${grandTotal}/-</td>
</tr>
<tr bgcolor="cyan">
   <td colspan="3"><a href="<c:url value="/productDisplay"/>">ContinueShopping</a></td>
</tr>   
     
</table>