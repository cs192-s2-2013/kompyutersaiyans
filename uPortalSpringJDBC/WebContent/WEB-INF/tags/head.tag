<%@tag description="Head Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" required="true"%>

<head>
	<style>
		body {
		 font-size: 20px;
		 color: teal;
		 font-family: Calibri;
		}
		
		a,a:visited{
			color: teal;
		}
		td {
		 font-size: 15px;
		 color: black;
		 width: 100px;
		 height: 22px;
		 text-align: left;
		}
		
		.errorblock {
		color: #ff0000;
		background-color: #ffEEEE;
		border: 1px solid #ff0000;
		padding: 8px;
		margin: 16px;
		width: 300px;
		font-size: small;
		}
		
		#message{
			color: black;
			padding: 20px;
		}
		
		#love{
			color: green;
		}
		.heading {
		 font-size: 18px;
		 color: white;
		 font: bold;
		 background-color: orange;
		 border: thick;
		}
		#rform{
			
			
		}
	</style>
	<title>${title} - uPortal</title>
</head>