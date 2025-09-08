<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<title>Login Riuscito</title>
	</head>
	<body>
		<h1>${messaggio}</h1>
		<p>Benvenuto nella pagina protetta, sarebbe corretto fare un redirect a / o /success ma per ora va bene così</p>
		<hr />
		<a href="/prova/articoli">Visualizza i tuoi articoli</a>
	</body>
</html>
