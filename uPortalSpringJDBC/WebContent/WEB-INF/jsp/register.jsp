<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Sign up">
	<div id="message">
		<c:if test="${msg_success == true}">Sign up success. You can now log in.</c:if>
	</div>

	<div>
		<form:form method="post" action="/submit" modelAttribute="user" commandName="user" id="rform">
			<table>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName" /></td>
					<td style="color: red; font-style: italic; font-size: small; width:200px;"><form:errors path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><form:input path="lastName"/></td>
					<td style="color: red; font-style: italic; font-size: small; width:200px;"><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="email" /></td>
					<td style="color: red; font-style: italic; font-size: small; width:200px;">
						<form:errors path="email" /><c:if test="${msg_failed == 2}">Email is already taken.</c:if>
					</td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><form:input path="username" /></td>
					<td style="color: red; font-style: italic; font-size: small; width:200px;">
						<form:errors path="username" /><c:if test="${msg_failed == 1}">Username is already taken.</c:if>
					</td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
					<td style="color: red; font-style: italic; font-size: small; width:200px;"><form:errors path="password" /></td>
				</tr>
				<tr>
					<td>Confirm Password :</td>
					<td><form:password path="confirmPassword" /></td>
					<td style="color: red; font-style: italic; font-size: small; width:200px;"><form:errors path="confirmPassword" /></td>
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
	
</t:genericpage>
  