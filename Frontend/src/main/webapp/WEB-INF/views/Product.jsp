<%@include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

<form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table align="center"  class="table table-bordered">

		<tr>
		   <td>Product Name</td>
		   <td> <form:input path="productName"/></td>
		</tr>
		<tr>
		   <td>Price</td>
		   <td> <form:input path="price"/></td>
		</tr>
		<tr>
		   <td>Stock</td>
		   <td> <form:input path="stock"/></td>
		</tr>
		<tr>
		    <td>Category</td>
		    <td><form:select path="categoryId">
		         <form:option value="0" label="--Select List--"/>
		         <form:options items="${categoryList}"/>
		        </form:select></td>
		</tr>
		<tr>
		    <td>SupplierId</td>
            <td><form:input path="supplierId"/></td>
		</tr>
			<tr>
			    <td>Product Description</td>
			   <td><form:input path="productDesc"/></td>
			</tr>
			
			<tr>
			   <td>Product image</td>
			   <td><input type="file" name="pimage" /></td>
			</tr>
			<tr>
			   <td colspan="2"><input type="submit" value="Insert" /></td>
			</tr>
</table>			
</form:form>

<table align="center" align="center" class="table table-bordered">

<tr>
      <td>Product ID</td>
      <td>Product Name</td>
      <td>Category</td>
      <td>Price</td>
      <td>Stock</td>
      <td>Supplier</td>
      <td>Operation</td>
</tr>
<c:forEach items="${productlist}" var="product">
<tr>
    <td>${product.productId}</td>
    <td>${product.productName}</td>
    <td>${product.categoryId}</td>
    <td>${product.price}</td>
    <td>${product.stock}</td>
    <td>${product.supplierId}</td>
    <td>
        <a class="btn  btn-success" href="<c:url value="/editProduct/${product.productId}"/>">Edit</a>
        <a class="btn  btn-danger" href="<c:url value="/deleteProduct/${product.productId}"/>">delete</a>
     </td>			
</tr>
</c:forEach>
</table>
</div>

