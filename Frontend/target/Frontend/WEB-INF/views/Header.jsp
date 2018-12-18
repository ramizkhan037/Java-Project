<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<title> Amazon </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">Logo</a>

 <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      
      <a class="nav-link" href="#">
	<font color="white"><span class="glyphicon glyphicon-home"></span></font>Home</a>
    </li>
    <c:if test="${!sessionScope.loggedIn}">
    <li class="nav-item"><a class="nav-link" href="login">Login</a></li>
    <li class="nav-item"><a class="nav-link" href="register">Register</a></li>
    <li class="nav-item"><a class="nav-link" href="aboutus">About Us</a></li>
    <li class="nav-item"><a class="nav-link" href="contactus">ContactUs</a></li>
    </c:if>
    <c:if test="${!sessionScope.loggedIn}">
            <c:if test="${!sessionScope.role=='ROLE_ADMIN'}">
     <li class="nav-item"><a class="nav-link" href="<c:url value='/category'/>">Category</a></li>
     <li class="nav-item"><a class="nav-link" href="<c:url value='/product'/>">Product</a></li>
            </c:if>
            <c:if test="${!sessionScope.role=='ROLE_USER'}">
     <li class="nav-item"><a class="nav-link" href="<c:url value='/productDisplay'/>">ProductDisplay</a></li>
             </c:if>
    </c:if> 
  </ul>
  </div>

<div class="nav navbar-nav navbar-right">
 <c:if test="${!sessionScope.loggedIn}">
   <div id="userdetail">
       <font color="white">
        Welcome ${sessionScope.username}
        <a href="/perform_logout" class="btn btn-danger">Logout</a>
       </font>
   </div>
 </c:if>
</div>

</nav>

