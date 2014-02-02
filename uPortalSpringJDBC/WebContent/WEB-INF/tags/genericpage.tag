<%@tag description="Generic Page Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true"%>

<html>
	<t:head title="${title}"></t:head>
	
	<body style="background:#FFF8DC;">
	<center>
		<div class="header" >
		    <div class="home-menu pure-menu pure-menu-open pure-menu-horizontal pure-menu-fixed" >
		        <a class="pure-menu-heading" href="home" style="float:left; font-size: 25px;">uPortal</a> 
				<c:if test="${username == null}">
		        	<ul style="float:right;">
		        		<li>
			            	<a href="home">Home</a>
			            </li>
			            <li>
			            	<a href="register">Sign up</a>
			            </li>
			            <li>
							<a href="login">Sign in</a>
			            </li>
		        	</ul>
		        </c:if>
		        <c:if test="${username != null}">
		        	<ul style="float:right;">
		        		<li>
		        			<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		        		</li>
		        	</ul>
		        </c:if>
		    </div>
		</div>
			<c:if test="${msg_success == true}"><div id="message">Sign up success. You can now login. </div></c:if> 
		<jsp:doBody/>
	</center>
	</body>
</html>