<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:userpage title="Welcome">
	<div class="pbanner">
		<div class="pure-g-r" id="pcont-div">
			<div id="prof-pic" class="pure-u-2-5">
				<img src=<c:url value="/resources/imgs/profile.jpeg"/>>
			</div>
			<div class="pure-u-2-3" id="pinfo">
				<div class="name">
					<h1>${user.getFirstName()} ${user.getLastName()}</h1>
				</div>
				<div class="details">
					<div class="info">Username: ${user.getUsername()}</div>
					<div class="info">Email: ${user.getEmail()}</div>
					<div class="info">Role: Wala pa ito. Lalalalalalalala</div>
					<div class="info">College: Wala rin ito. Lalalalalala</div>
					<div class="info">Department: Wala pa rin. Lalalalalala</div>
					<div class="info">Course: Lalalalalalala~~~~~~~ :))</div>
				</div>
			</div>
		</div>
	</div>
	<div id="prof-links">	
		<a href="#"><button class="pure-button"><i class="fa fa-laptop"></i><br>UP Maps</button></a>
		<a href="#"><button class="pure-button"><i class="fa fa-money"></i><br>Study Buddy</button></a>
		<a href="#"><button class="pure-button"><i class="fa fa-youtube-play"></i><br>Brain Gym</button></a>
		<a href="#"><button class="pure-button"><i class="fa fa-cut"></i><br>Online Classroom</button></a>
	</div>
</t:userpage>
	