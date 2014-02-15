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
								<a href="#" class="section">
									<img class="image" src=<c:url value="/resources/images/img1.jpg"/> width="26" height="26" />
									<span class="text-box">
										Welcome
										<strong class="name">Admin</strong>
									</span>
								</a>
							</span>
							
							<a href="#" class="btn-on">Log Out</a>
							
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
							
						</div>
						<div id="tab-4" class="tab">
							
							
						</div>
						
						<div id="tab-8" class="tab">
							<article>
								<div class="text-section">
									<h1>Settings</h1>
									<p>Configure admin control panel here</p>
									</br>
									<p><u>Hit Counter</u></p>
									<p>Number of visitors: <b> ${cookie.hitCounter.value} </b></p>
									<p><b><a href='#'>Reset counter</a></b></p>
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
						<a href="#tab-8" class="ico8"><span>Settings</span><em></em></a>
						<span class="tooltip"><span>Settings</span></span>
					</li>
				</ul>
				
			</aside>
		</div>
	</body>