<%@tag description="Generic Page Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true"%>

<html>
	<t:head title="${title}"></t:head>
	
	<body style="background:#FFFAF0;">
	<center>
		<div class="header" >
		    <div class="home-menu pure-menu pure-menu-open pure-menu-horizontal pure-menu-fixed" >
		        <a class="pure-menu-heading" href="home" style="float:left; font-size: 25px;">uPortal</a> 
		        <ul style="float:right;">
		        	<c:if test="${username == null}">
		        		<li>
			            	<a href="home">Home</a>
			            </li>
			            <li>
			            	<a href="register">Sign up</a>
			            </li>
			            <li>
							<a href="login">Sign in</a>
			            </li>
		       		</c:if>
		       		 <c:if test="${username != null}">
		       		 	<li>
		        			<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
		        		</li>
		        	</c:if>
		        	<li>
		        		<a href="hotlines">Hotlines</a>
		        	</li>
		        	<li>
		        		<a href="description">Applications</a>
		        	</li>
		        </ul>
		    </div>
		</div>
			<c:if test="${msg_success == true}"><div id="message">Sign up success. You can now login. </div></c:if>
			<c:if test="${reset_success == true}"><div id="message">The hit counter was successfully reseted </div></c:if>  
		<jsp:doBody/>
	</center>
	</body>
</html>