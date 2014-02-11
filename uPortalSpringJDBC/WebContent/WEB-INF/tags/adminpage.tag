<%@tag description="Head Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="title" required="true"%>

<head>
	<link rel="stylesheet" href=<c:url value="/resources/css/all.css"/>>
	<link rel="stylesheet" type="text/css" href=<c:url value="/resources/css/ie.css"/>>
	<link rel="stylesheet" type="text/css" href=<c:url value="/resources/css/pricing.css"/>>
	<link href=<c:url value="/resources/images/img1.jpg"/> rel='images'>
	<title>${title} - uPortal</title>
</head>