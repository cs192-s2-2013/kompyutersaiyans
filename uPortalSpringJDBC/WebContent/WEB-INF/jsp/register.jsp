<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Sign up">
	<div class="headers">
		<h1>Register</h1>	
	</div>
	<center>
		<div class="formdiv">
			<form:form method="post" action="/submit" modelAttribute="user" commandName="user" id="rform" class="pure-form">	
				<div class="form-fields">
					<form:input path="firstName" class="pure-input-1-3" placeholder="First name" required="true"/>
					<label style="color: red; font-style: italic; font-size: small; width:200px;" class=comment><form:errors path="firstName" /></label>
				</div>
				<div class="form-fields">
					<form:input path="lastName" class="pure-input-1-3" placeholder="Last name" required="true"/>
					<label style="color: red; font-style: italic; font-size: small; width:200px;" class=comment><form:errors path="lastName" /></label>
				</div>
				<div class="form-fields">
					<form:input path="email" class="pure-input-1-3" placeholder="Email address" required="true"/>
					<label style="color: red; font-style: italic; font-size: small; width:200px;" class=comment>
						<form:errors path="email" /><c:if test="${msg_failed == 2}">Email is already taken.</c:if>
					</label>
				</div>
				<div class="form-fields">
					<form:input path="username" class="pure-input-1-3" placeholder="Username" required="true"/>
					<label style="color: red; font-style: italic; font-size: small; width:200px;" class=comment>
						<form:errors path="username" /><c:if test="${msg_failed == 1}">Username is already taken.</c:if>
					</label>
				</div>
				<div class="form-fields">
					<form:password path="password" class="pure-input-1-3" placeholder="Password" required="true"/>
					<label style="color: red; font-style: italic; font-size: small; width:200px;" class=comment>
						<form:errors path="password" />
					</label>
				</div>
				<div class="form-fields">
					<form:password path="confirmPassword" class="pure-input-1-3" placeholder="Confirm password" required="true"/>
					<label style="color: red; font-style: italic; font-size: small; width:200px;" class=comment>
						<form:errors path="confirmPassword" />
					</label>
				</div>
				<div class="form-fields">
					<button type="submit" class="pure-button pure-input-1-3 pure-button-primary" value="Save" style="background: #8e44ad; border-radius: 5px;">Submit</button>
				</div>
			</form:form>
		</div>
	</center>
	
</t:genericpage>
  