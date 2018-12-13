<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/><br/><br/>

<form action="<c:url value="/addToCart/${product.productId}"/>" method="get">
<div class="container">
        	<div class="row">
               <div class="col-xs-4 item-photo">
                    <img src="<c:url value="/resources/images/${product.productId}.jpg"/>"/>
                </div>
              
                <div class="col-xs-5" style="border:0px solid gray">
                
                    
                    <h3>${product.productName}</h3>    
                    
                    <h6 class="title-price">
                       <small>Stock: ${product.stock}</small>
                    </h6>
                    <h3 style="margin-top:0px;">Price: INR ${product.price}</h3>
        
                    <div class="section">
                        <h6 class="title-attr" style="margin-top:15px;" >
                        <small>Description: ${product.productDesc}</small>
                        </h6>                    
                        <div>
                            <div class="attr" style="width:25px;background:#5a5a5a;"></div>
                            <div class="attr" style="width:25px;background:white;"></div>
                        </div>
                    </div>
                                        
                        <div>
                            <div class="btn-minus">
                              <span class="glyphicon glyphicon-minus"></span>
                            </div>
                            <input value="1" name="quantity" />
                            <div class="btn-plus">
                               <span class="glyphicon glyphicon-plus"></span>
                            </div>
                        </div>
                                    
        
          
                    
                    <div class="section" style="padding-bottom:20px;">
                       <input type="submit" class="btn btn-success" value="Add to Cart">
                        
                    </div>                                        
                
             </div>                             
        </div>
    </div>        
</form>     
