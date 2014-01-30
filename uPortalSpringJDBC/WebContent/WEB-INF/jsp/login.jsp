<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Sign in">
	
	<div>
		<c:if test="${not empty error}">
			<div class="errorblock">
			Invalid username or password.
			</div>
		</c:if>
		
		<form name='f' id="rform" action="<c:url value='/j_spring_security_check' />"
		method='POST'>
			<table onload='document.f.j_username.focus();'>
				<tr>
					<td>User:</td>
					<td><input type='text' name='j_username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td> </td>
					<td><input name="submit" type="submit"
					value="Submit" /></td> 
				</tr>
			</table>
		</form>
	</div>
	
</t:genericpage>