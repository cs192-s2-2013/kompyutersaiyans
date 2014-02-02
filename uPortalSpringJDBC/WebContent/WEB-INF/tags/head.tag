<%@tag description="Head Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="title" required="true"%>

<head>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/base/css/base.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/buttons/css/buttons.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/buttons/css/buttons-core.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/forms/css/forms.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/forms/css/forms-r.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/grids/css/grids-core.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/grids/css/grids-r.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/menus/css/menus-core.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/menus/css/menus-paginator.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/menus/css/menus-r.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/menus/css/menus.css"/>>
	<link rel="stylesheet" href=<c:url value="/resources/css/pure/src/tables/css/tables.css"/>>
	<link rel="stylesheet" type="text/css" href=<c:url value="/resources/css/style.css>"/>>
	<title>${title} - uPortal</title>
</head>