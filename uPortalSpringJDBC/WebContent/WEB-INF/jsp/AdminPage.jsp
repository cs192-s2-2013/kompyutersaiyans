<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:adminpage title="${title}"></t:adminpage>
	<body>
		<header>
		<font size = "15"> UPortal</font>
		</header>
		<div id="wrapper">
			<div id="content">
				<div class="c1">
					<div class="controls">
						<nav class="links">
							<ul>
								
								<li><a href="#" class="ico2">Requests<span class="num">1</span></a></li>
							</ul>
						</nav>
						<div class="profile-box">
							<span class="profile">
								<a href="welcome" class="section">
									<img class="image" src=<c:url value="/resources/images/img1.jpg"/> width="26" height="26" />
									<span class="text-box">
										Welcome
										<strong class="name">Admin</strong>
									</span>
								</a>
							</span>
							
							<a href="<c:url value="/j_spring_security_logout" />" class="btn-on">Log Out</a>
							
						</div>
					</div>
					<div class="tabs">
						<div id="tab-1" class="tab">
							<article>
								<div class="text-section">
									<h1>Dashboard</h1>
									<p>This is a quick overview of some features</p>
								</div>
								<ul class="states">
									<li class="error">Error : This is an error placed text message.</li>
									<li class="warning">Warning: This is a warning placed text message.</li>
									<li class="succes">Succes : This is a succes placed text message.</li>
								</ul>
							</article>
						</div>
						<div id="tab-2" class="tab">
							<article>
								<div class="text-section">
									<h1>Dashboard</h1>
									<p>This is a quick overview of some features</p>
								</div>
								<ul class="states">
									<li class="error">Error : This is an error placed text message.</li>
									<li class="warning">Warning: This is a warning placed text message.</li>
									<li class="succes">Succes : This is a succes placed text message.</li>
								</ul>
							</article>
						</div>
						<div id="tab-3" class="tab">
							<style>  
								    body {  
								     font-size: 20px;  
								     color: teal;  
								     font-family: Calibri;  
								    }  
								      
								    td {  
								     font-size: 15px;  
								     color: black;  
								     width: 100px;  
								     height: 22px;  
								     text-align: center;  
								    }  
								    .heading {  
								     font-size: 18px;  
								     color: white;  
								     font: bold;  
								     background-color: orange;  
								     border: thick;  
								    }  
								    </style>  
								    <body>  
								     <center>  
								        
								       
								       
								     <b>Admin List | uPortal </b>  
								       
								      
								         
								        
								      
								      <table border="1">  
								       <tr>  
								        <td class="heading">User Id</td>  
								        <td class="heading">First Name</td>  
								        <td class="heading">Last Name</td>  
								        <td class="heading">Email</td>  
								        <td class="heading">Username</td>
								        <td class="heading">Password</td>  
								        <td class="heading">Edit</td>  
								        <td class="heading">Delete</td>  
								       </tr>  
								       <c:forEach var="user" items="${userList}">  
								        <tr>  
								         <td>${user.userId}</td>  
								         <td>${user.firstName}</td>  
								         <td>${user.lastName}</td>  
								         <td>${user.email}</td>  
								         <td>${user.username}</td>  
								         <td>${user.password}</td>
								         <td><a href="edit?userid=${user.userId}">Edit</a></td>  
								         <td><a href="delete?userid=${user.userId}">Delete</a></td>  
								        </tr>  
								       </c:forEach>  
								       <tr><td colspan="7"><a href="register">Add New User</a></td></tr>  
								      </table>  
								      
								     </center>  
						</div>
						<div id="tab-4" class="tab">
							         <style>  
							    body {  
							     font-size: 20px;  
							     color: teal;  
							     font-family: Calibri;  
							    }  
							      
							    td {  
							     font-size: 15px;  
							     color: black;  
							     width: 100px;  
							     height: 22px;  
							     text-align: center;  
							    }  
							    .heading {  
							     font-size: 18px;  
							     color: white;  
							     font: bold;  
							     background-color: orange;  
							     border: thick;  
							    }  
							    </style>  
							    <body>  
							     <center>  
							        
							       
							       
							     <b>User List | uPortal </b>  
							       
							      
							         
							        
							      
							      <table border="1">  
							       <tr>  
							        <td class="heading">User Id</td>  
							        <td class="heading">First Name</td>  
							        <td class="heading">Last Name</td>  
							        <td class="heading">Email</td>  
							        <td class="heading">Username</td>
							        <td class="heading">Password</td>  
							        <td class="heading">Edit</td>  
							        <td class="heading">Delete</td>  
							       </tr>  
							       <c:forEach var="user" items="${userList}">  
							        <tr>  
							         <td>${user.userId}</td>  
							         <td>${user.firstName}</td>  
							         <td>${user.lastName}</td>  
							         <td>${user.email}</td>  
							         <td>${user.username}</td>  
							         <td>${user.password}</td>
							         <td><a href="edit?userid=${user.userId}">Edit</a></td>  
							         <td><a href="delete?userid=${user.userId}">Delete</a></td>  
							        </tr>  
							       </c:forEach>  
							       <tr><td colspan="7"><a href="register">Add New User</a></td></tr>  
							      </table>  
							      
							     </center>  
							
						</div>
						<div id="tab-5" class="tab">
							<article>
								<style>  
								    body {  
								     font-size: 20px;  
								     color: teal;  
								     font-family: Calibri;  
								    }  
								      
								    td {  
								     font-size: 15px;  
								     color: black;  
								     width: 100px;  
								     height: 22px;  
								     text-align: center;  
								    }  
								    .heading {  
								     font-size: 18px;  
								     color: white;  
								     font: bold;  
								     background-color: orange;  
								     border: thick;  
								    }  
								    </style>  
								    <body>  
								     <center> 
								     <b>Hotline List | uPortal </b> 
								     <hr/>
								      <table border="1" width="95%">  
								      <col width="5%">
								      <col width="25%">
								      <col width="60%">
								      <col width="5%">
								      <col width="5%">
								       <tr>  
								        <td class="heading">Id</td>  
								        <td class="heading">Entity Name</td>  
								        <td class="heading">Description</td>  
								        <td class="heading" colspan="2">Options</td>
								       </tr>  
								       <c:forEach var="tel" items="${hotlineList}">
								        <tr>  
								         <td>${tel.getValue()}</td>  
								         <td>${tel.getLabel()}</td>  
								         <td>${tel.getTelInfo()}</td>
								         <td><a href="editNum?id=${user.userId}">Edit</a></td>  
								         <td><a href="deleteNum?id=${user.userId}">Delete</a></td>  
								        </tr>  
								       </c:forEach>  
								       <tr><td colspan="5"><a href="">add new hotline</a></td></tr>  
								      </table>  
								     </center>  
								 <ul class="states">
									<li class="warning">When editing hotline numbers, please separate them with asterisk.</li>
								</ul>
							</article>
						</div>
						
						<div id="tab-8" class="tab">
							<article>
								<div class="text-section">
									<h1>Settings</h1>
									<p>Configure admin control panel here</p>
									<c:if test="${reset_success == true}">
									<p><b>The hit counter was successfully reseted</b></p>
									</c:if>
									
									</br>
									<p><u>Hit Counter</u></p>
									<p>Number of visitors: <b> ${homePageCounter} </b></p>
									<p><b><a href="reset">Reset counter</a></b></p>
									
								</div>
							</article>
						</div>
					</div>
				</div>
			</div>
			<aside id="sidebar">
				
				<ul class="tabset buttons">
					<li class="active">
						<a href="#tab-1" class="ico1"><span>Dashboard</span><em></em></a>
						<span class="tooltip"><span>Dashboard</span></span>
					</li>
					<li>
						<a href="#tab-2" class="ico4"><span>Applications</span><em></em></a>
						<span class="tooltip"><span>Applications</span></span>
					</li>
					<li>
						<a href="#tab-3" class="ico3"><span>Admins</span><em></em></a>
						<span class="tooltip"><span>Admins</span></span>
					</li>
					<li>
						<a href="#tab-4" class="ico3"><span>Users</span><em></em></a>
						<span class="tooltip"><span>Users</span></span>
					</li>
					<li>
						<a href="#tab-5" class="ico3"><span>Edit Hotlines</span><em></em></a>
						<span class="tooltip"><span>Edit Hotlines</span></span>
					</li>
					
					<li>
						<a href="#tab-8" class="ico8"><span>Settings</span><em></em></a>
						<span class="tooltip"><span>Settings</span></span>
					</li>
				</ul>
				
			</aside>
		</div>
	</body>