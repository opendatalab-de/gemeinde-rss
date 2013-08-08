<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Gemeinde RSS - OpenDataLab</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>Gemeinde RSS</h1>
			<p>Alle Nachrichten aus deiner Gemeinde und Umgebung</p>

		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Gemeinde</th>
					<th>Aktuelles</th>
					<th>Datum</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.gemeinde}</td>
						<td><a target="gemeindeFeed" href="${item.rssFeed.link}">${item.rssFeed.title}</a>
						<td>
						<fmt:formatDate value="${item.rssFeed.pubDate}" type="date" dateStyle="medium"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- JavaScript plugins (requires jQuery) -->
	<!--  script src="http://code.jquery.com/jquery.js"></script -->
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<!-- script src="assets/js/bootstrap.min.js"></script -->
</body>
</html>
