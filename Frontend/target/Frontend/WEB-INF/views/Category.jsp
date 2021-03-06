<%@include file="Header.jsp" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
<h3 align="center">Category Page</h3>

<form action="<c:url value="/addCategory"/>" method="post" >

<table align="center"  class="table table-bordered">
	<tr>
		<td>Category Name </td>
		<td><input type="text" id="categoryName" name="categoryName"value="${category.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Desc </td>
		<td><input type="text" id="categoryDesc" name="categoryDesc"value="${category.categoryDesc}"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Add Category"/></td>
	</tr>
</table>
</form>


<table align="center" align="center" class="table table-bordered">
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a class="btn  btn-success" href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
			<a class="btn  btn-danger" href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
</div>

</body>
</html>