<%@tag description="Head Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="title" required="true"%>

<head>
	<link rel="stylesheet" href=<c:url value="/resources/css/all.css"/>>
	<link rel="stylesheet" type="text/css" href=<c:url value="/resources/css/ie.css"/>>
	<link rel="stylesheet" type="text/css" href=<c:url value="/resources/css/pricing.css"/>>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript">window.jQuery || document.write('<script type="text/javascript" src="js/jquery-1.7.2.min.js"><\/script>');</script>
	<script type="text/javascript" src= <c:url value = "/resources/js/jquery.main.js"/>></script>
	<title>${title} - uPortal</title>
</head>
 src=<c:url value="/resources/images/img1.jpg"/>