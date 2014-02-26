<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Request To Be An Admin">
	<div class="headers">
		<h1>Request To Be An Admin</h1>	
	</div>
	
	
	<div class="cont-div" >
		<div>
			<a href="request_portal">Request to be a PORTAL admin</a>
		</div>
		<br>
		<div>
			<a href="request_maps">Request to be a UP MAP admin</a>
		</div>
		<br>
		<div>
			<a href="request_buddy">Request to be a STUDY BUDDY admin</a>
		</div>
		<br>
		<div>
			<a href="request_class">Request to be an ONLINE CLASSROOM admin</a>
		</div>
				<br>
		<div>
			<a href="request_gym">Request to be a BRAIN GYM admin</a>
		</div>
		
	</div>

</t:genericpage>