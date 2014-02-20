<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Hotlines">
	<div class="headers">
		<h1>Hotlines</h1>	
	</div>
	
	
	<div class="cont-div" >
		<div class="htln-left" >
		
			<c:forEach var="hotline" items="${hotlineList}">
				<h4><c:out value="${hotline.getValue()}"/></h4>
				<ul>
					<li><c:out value="${hotline.getLabel()}"/></li>
				</ul>
			</c:forEach>
			
		 	<h4>UP Diliman Police</h4>
			<ul>
				<li>9283615</li>
				<li>9818500 loc 4008 (Radio Room)</li>
				<li>113 (Helpdesk)</li>
			</ul>
			
			<h4>University Health Service</h4>
			<ul>
				<li>9818500 loc 111</li>
			</ul>
			
			<h4>Bureau of Fire Protection</h4>
			<ul>
				<li>928-8363 (Quezon City Hall)</li>
				<li>924-1922</li>
				<li>441-8279 (Libis)</li>
				<li>492-7576 (Loyola Heights)</li>
				<li>931-9894 (New Era)</li>
			</ul>
			
			<h4>Bomb Squad</h4>
			<ul>
				<li>436-0948</li>
				<li>924-3101</li>
			</ul>
		</div>
		
		<div class="htln-right">
			<h4>Philippine National Red Cross Quezon City Chapter</h4>
			<ul>
				<li>920-3672</li>
				<li>433-6568 (Blood Bank)</li>
				<li>433-2151 to 52</li>
				<li>434-3751</li>
			</ul>
			
			<h4>Meralco</h4>
			<ul>
				<li>631-1111</li>
				<li>162-11</li>
			</ul>
			
			<h4>PLDT</h4>
			<ul>
				<li>173 / 171</li>
			</ul>
		</div>
	</div>

</t:genericpage>