<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
	 
<t:genericpage title="Home">
	<div class="headers">
		<h1>Home</h1>	
	</div>
	<div class="htln-div">
		<div style="margin-left:30px; margin-right: 30px;">
			<h3>Online Classroom</h3>
			<p class="desc">App that lets you collaborate with your professor and classmates online! Come on and have your class online!</p>
			<c:if test="${username != null}">
				<div class="vis-site">
					<a href="#" style="color: #8e44ad;">visit site -></a>
				</div>
			</c:if>
			<c:if test="${username == null}">
				<div class="vis-siteNL">
					You have to <a href="login" style="color: #8e44ad;">sign in</a> to view this site.
				</div>	
			</c:if>
			<h3>UP Map</h3>
			<p class="desc">Not yet familiar with the whereabouts of different places in UP Diliman? Try this app! Surely, it will help you how to go there as fast as possible!</p>
			<div class="vis-site">
				<a href="#" style="color: #8e44ad;">visit site -></a>
			</div>
			<h3>Brain gym</h3>
			<p class="desc">We know that you are genius! Want to test your genius right now?</p>
			<c:if test="${username != null}">
				<div class="vis-site">
					<a href="#" style="color: #8e44ad;">visit site -></a>
				</div>
			</c:if>
			<c:if test="${username == null}">
				<div class="vis-siteNL">
					You have to <a href="login" style="color: #8e44ad;">sign in</a> to view this site.
				</div>	
			</c:if>
			<h3>Study Buddy</h3>
			<p class="desc">Having a hard time managing your study life with the many luring stuff meddling upon your studies? Study Buddy is your best friend!</p>
			<div class="vis-site">
				<a href="#" style="color: #8e44ad;">visit site -></a>
			</div>
		</div>
	</div>
</t:genericpage>