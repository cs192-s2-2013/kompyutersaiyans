<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
	<title>uPortal | Welcome</title>
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
	
	#message{
		color: black;
		padding: 20px;
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
<b><a href="home">uPortal</a> | Welcome </b> 
<body>
	<br/>
	<div id="message">
		${message}, ${username}!
	</div>
	
 
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
 
</body>
</html>