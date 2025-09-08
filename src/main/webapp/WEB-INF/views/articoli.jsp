<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
	<head>
		<title>Pagina Articoli</title>
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
							<td>${art.peso}</td>
							<td>${art.prezzo}</td>
						</tr>
					</c:forEach>
				</tbody>

		</table>
	</body>
</html>
