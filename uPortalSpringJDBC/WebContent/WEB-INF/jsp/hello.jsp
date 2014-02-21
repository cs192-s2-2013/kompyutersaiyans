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
					<div class="info">
						Role: <c:forEach var="i" begin="0" end="${roles.size()-1}"> ${roles.get(i)} </c:forEach>
					</div>
					<c:if test="${college != null}">
						<div class="info">College: ${college}</div>
					</c:if>
					<c:if test="${department != null}">
						<div class="info">Department: ${department}</div>
					</c:if>
					<c:if test="${course != null}">
						<div class="info">Course: ${course}</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div id="prof-links">	
		<a href="#" title="visit UP Map"><button class="pure-button"><i class="fa fa-laptop"></i><br>UP Map</button></a>
		<a href="#" title="visit Study Buddy"><button class="pure-button"><i class="fa fa-money"></i><br>Study Buddy</button></a>
		<c:if test="${college == 'College of Engineering' || college == 'College of Science'}">
			<a href="#" title="visit Brain Gym"><button class="pure-button"><i class="fa fa-youtube-play"></i><br>Brain Gym</button></a>
		</c:if>
		<c:if test="${college != 'College of Engineering' && college != 'College of Science'}">
			<button class="pure-button" title="available to College of Engineering and Science students only" disabled><i class="fa fa-youtube-play"></i><br>Brain Gym</button>
		</c:if>
		<c:if test="${department == 'Department of Computer Science'}">
			<a href="#" title="visit Online Classroom"><button class="pure-button"><i class="fa fa-cut"></i><br>Online Classroom</button></a>
		</c:if>
		<c:if test="${department != 'Department of Computer Science'}">
			<button class="pure-button" title="available to DCS students only" disabled><i class="fa fa-cut"></i><br>Online Classroom</button>
		</c:if>
	</div>
</t:userpage>
	