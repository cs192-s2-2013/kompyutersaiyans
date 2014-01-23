<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<title>uPortal | Sign Up</title>
	<style>
	body {
	 font-size: 20px;
	 color: teal;
	 font-family: Calibri;
	}
	
	td {
	 font-size: 15px;
	 color: black;
	 width: 100px;
	 height: 22px;
	 text-align: left;
	}
	
	#love{
		color: green;
	}
	.heading {
	 font-size: 18px;
	 color: white;
	 font: bold;
	 background-color: orange;
	 border: thick;
	}
	</style>
	</head>
	<body>
	 <center>
	  
	 
	 
	 <b>uPortal | Registration Form </b> 
	
	
	  <div>
	   <form:form method="post" action="/insert" modelAttribute="user" >
	    <table>
	     <tr>
	      <td>First Name :</td>
	      <td><form:input path="firstName" /></td>
	     </tr>
	     <tr>
	      <td>Last Name :</td>
	      <td><form:input path="lastName"/></td>
	     </tr>
	     <tr>
	      <td>Email :</td>
	      <td><form:input path="email" /></td>
	     </tr>
	     <tr>
	      <td>Username :</td>
	     <td><form:input path="username" /></td>
	     </tr>
	     <tr>
	      <td>Password :</td>
	     <td><form:password path="password" /></td>
	     </tr>
	     <tr>
	      <td> </td>
	      <td><input type="submit" value="Save" /></td>
	     </tr>
	     <tr>
	     </tr>
	    </table>
	   </form:form>
	  </div>
	 </center>
	</body>
</html>
