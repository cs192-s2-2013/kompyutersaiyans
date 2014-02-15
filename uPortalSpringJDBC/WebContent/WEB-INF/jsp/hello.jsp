<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:userpage title="Welcome">
	<br/>
	<div id="message">
		${message}, ${username}!
	</div>
	<div id="message">
		<a href='req_admin'>Request as admin</a>
	</div>
</t:userpage>
	