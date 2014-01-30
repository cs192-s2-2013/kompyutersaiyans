<%@tag description="Generic Page Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true"%>

<html>
	<t:head title="${title}"></t:head>
	
	<body>
	<center>
		<div id="header">
			<b><a href="home">uPortal</a> | ${title} </b> 
		
			<div>
				<c:if test="${username != null}"><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></c:if>
			</div>
			<div>
				<c:if test="${msg_success == true}">Sign up success. You can now log in.</c:if>
			</div>
			
			<c:if test="${username == null}">
				<div>
					<a href="register">Sign up</a>
					<a href="login">Sign in</a>
				</div>
			
			</c:if>
		</div>
		<jsp:doBody/>
	</center>
	</body>
</html>