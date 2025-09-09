<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
	<head>
		<title>Pagina Articoli</title>
		<form:form id="search" role="search" method="GET" action="/prova/articoli/search">
			<input type="text" onClick="this.select();" name="filtro" value="${filtro}" placeholder="Cerca..." />
			<input type="submit" />
		</form:form>
	</head>
	<body>
		<h1>Articoli di ${email}</h1>
		<table>
			<thead>
				<tr>
					<th>Codice</th>
					<th>Descrizione</th>
					<th>UM</th>
					<th>Pezzi</th>
					<th>Peso</th>
					<th>Prezzo</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach items="${articoli}" var="art">
						<tr>
							<td>${art.codArt}</td>
							<td>${art.descrizione}</td>
							<td>${art.um}</td>
							<td>${art.pzcart}</td>
							<td>${art.pesoNetto}</td>
						</tr>
					</c:forEach>
				</tbody>

		</table>
		<c:if test="${NotFound}">
			<div>
				Articolo non presente
			</div>
		</c:if>
	</body>
</html>
