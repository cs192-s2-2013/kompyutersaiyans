<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
	body {
	 font-size: 20px;
	 color: teal;
	 font-family: Calibri;
	}
	
	a,a:visited{
		color: teal;
	}
	td {
	 font-size: 15px;
	 color: black;
	 width: 100px;
	 height: 22px;
	 text-align: left;
	}
	
	.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 1px solid #ff0000;
	padding: 8px;
	margin: 16px;
	width: 300px;
	font-size: small;
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
	#rform{
		
		
	}
	</style>
</head>


<body onload='document.f.j_username.focus();'>
<center>
	<b><a href="home">uPortal</a> | Sign in </b> 
 
	
 
 	<div>
 		<c:if test="${not empty error}">
			<div class="errorblock">
				Invalid username or password.
			</div>
		</c:if>
 		<form name='f' id="rform" action="<c:url value='/j_spring_security_check' />"
		method='POST'>
 
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td><input name="submit" type="submit"
					value="Submit" />
				</td> 
				
			</tr>
		</table>
 
	</form>
 	</div>
 	</center>
</body>
</html>